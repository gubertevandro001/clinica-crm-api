package com.gpa.clinica.crm.domain.service;

import com.gpa.clinica.crm.api.model.request.AtualizarPacienteRequest;
import com.gpa.clinica.crm.api.model.request.CadastrarPacienteRequest;
import com.gpa.clinica.crm.domain.exception.PacienteNaoEncontradoException;
import com.gpa.clinica.crm.domain.mapper.ContatoMapper;
import com.gpa.clinica.crm.domain.mapper.EnderecoMapper;
import com.gpa.clinica.crm.domain.mapper.PacienteMapper;
import com.gpa.clinica.crm.domain.entity.Conversa;
import com.gpa.clinica.crm.domain.entity.Paciente;
import com.gpa.clinica.crm.domain.entity.Usuario;
import com.gpa.clinica.crm.domain.repository.ConversaRepository;
import com.gpa.clinica.crm.domain.repository.PacienteRepository;
import com.gpa.clinica.crm.domain.util.TextExtractor;
import com.gpa.clinica.crm.domain.util.LoggedUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private final ConversaRepository conversaRepository;
    private final UsuarioService usuarioService;

    public PacienteService(PacienteRepository pacienteRepository, ConversaRepository conversaRepository,
                           UsuarioService usuarioService) {
        this.pacienteRepository = pacienteRepository;
        this.conversaRepository = conversaRepository;
        this.usuarioService = usuarioService;
    }

    public Paciente buscarPorId(String pacienteId) {
        return pacienteRepository.findById(pacienteId).orElseThrow(() -> new PacienteNaoEncontradoException(pacienteId));
    }

    public List<Paciente> buscarTodos() {
        return pacienteRepository.findAll();
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
    public Conversa adicionarConversa(String pacienteId, MultipartFile arquivoDaConversa) {
        Paciente paciente = buscarPorId(pacienteId);
        Usuario usuario = usuarioService.buscarPorId(LoggedUser.getId());

        Conversa conversa = Conversa.novaConversa(TextExtractor.extract(arquivoDaConversa), paciente, usuario);

        paciente.adicionarConversa(conversa);

        return conversaRepository.save(conversa);
    }
}