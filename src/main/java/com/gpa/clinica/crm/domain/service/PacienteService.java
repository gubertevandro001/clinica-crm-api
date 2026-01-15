package com.gpa.clinica.crm.domain.service;

import com.gpa.clinica.crm.api.model.request.AtualizarPacienteRequest;
import com.gpa.clinica.crm.api.model.request.CadastrarPacienteRequest;
import com.gpa.clinica.crm.api.model.request.PageableRequest;
import com.gpa.clinica.crm.domain.exception.PacienteNaoEncontradoException;
import com.gpa.clinica.crm.domain.mapper.ContatoMapper;
import com.gpa.clinica.crm.domain.mapper.EnderecoMapper;
import com.gpa.clinica.crm.domain.mapper.PacienteMapper;
import com.gpa.clinica.crm.domain.entity.Conversa;
import com.gpa.clinica.crm.domain.entity.Paciente;
import com.gpa.clinica.crm.domain.entity.Usuario;
import com.gpa.clinica.crm.domain.repository.PacienteRepository;
import com.gpa.clinica.crm.domain.util.TextExtractor;
import com.gpa.clinica.crm.domain.util.LoggedUser;
import com.gpa.clinica.crm.infrastructure.spec.BuscaPacientesSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private final UsuarioService usuarioService;

    public PacienteService(PacienteRepository pacienteRepository, UsuarioService usuarioService) {
        this.pacienteRepository = pacienteRepository;
        this.usuarioService = usuarioService;
    }

    public Paciente buscarPorId(String pacienteId) {
        return pacienteRepository.findById(pacienteId).orElseThrow(() -> new PacienteNaoEncontradoException(pacienteId));
    }

    public Page<Paciente> buscarPorFiltro(PageableRequest request) {
        Pageable pageable = PageRequest.of(request.numeroDaPagina() - 1, request.registrosPorPagina());
        return pacienteRepository.findAll(BuscaPacientesSpecification.buscarPor(request.filtro()), pageable);
    }

    public Paciente cadastrar(CadastrarPacienteRequest request) {
        return pacienteRepository.save(PacienteMapper.criarPaciente(request));
    }

    public Paciente atualizar(String pacienteId, AtualizarPacienteRequest request) {
        Paciente paciente = buscarPorId(pacienteId);

        paciente.atualizar(
                request.nome(),
                request.idade(),
                request.dataNascimento(),
                request.profissao(),
                request.estadoCivil(),
                EnderecoMapper.criarEndereco(request.endereco()),
                ContatoMapper.criarContato(request.contato()),
                request.anamnese().habitosDiarios().anotacoes()
        );

        return pacienteRepository.save(paciente);
    }

    @Transactional
    public void adicionarConversa(String pacienteId, MultipartFile arquivoDaConversa) {
        Paciente paciente = buscarPorId(pacienteId);
        Usuario usuario = usuarioService.buscarPorId(LoggedUser.getId());

        Conversa conversa = Conversa.novaConversa(TextExtractor.extract(arquivoDaConversa), paciente, usuario);

        paciente.adicionarConversa(conversa);

        pacienteRepository.save(paciente);
    }
}