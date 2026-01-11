package com.gpa.clinica.crm.domain.service;

import com.gpa.clinica.crm.api.model.AtualizarPacienteRequest;
import com.gpa.clinica.crm.api.model.CadastrarPacienteRequest;
import com.gpa.clinica.crm.domain.mapper.ContatoMapper;
import com.gpa.clinica.crm.domain.mapper.EnderecoMapper;
import com.gpa.clinica.crm.domain.mapper.PacienteMapper;
import com.gpa.clinica.crm.domain.model.Conversa;
import com.gpa.clinica.crm.domain.model.Paciente;
import com.gpa.clinica.crm.domain.model.Usuario;
import com.gpa.clinica.crm.domain.repository.ConversaRepository;
import com.gpa.clinica.crm.domain.repository.PacienteRepository;
import com.gpa.clinica.crm.domain.util.UsuarioLogadoUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private final ConversaRepository conversaRepository;
    private final ExtracaoTextoService extracaoTextoService;
    private final UsuarioService usuarioService;

    public PacienteService(PacienteRepository pacienteRepository, ConversaRepository conversaRepository,
                           ExtracaoTextoService extracaoTextoService, UsuarioService usuarioService) {
        this.pacienteRepository = pacienteRepository;
        this.conversaRepository = conversaRepository;
        this.extracaoTextoService = extracaoTextoService;
        this.usuarioService = usuarioService;
    }

    public Paciente buscarPorId(String pacienteId) {
        return pacienteRepository.findById(pacienteId).orElse(null);
    }

    public List<Paciente> buscarTodos() {
        return pacienteRepository.findAll();
    }

    public Paciente cadastrarPaciente(CadastrarPacienteRequest request) {
        return pacienteRepository.save(PacienteMapper.criarPaciente(request));
    }

    public Paciente atualizarPaciente(String pacienteId, AtualizarPacienteRequest request) {
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

    public Conversa adicionarConversa(String pacienteId, MultipartFile arquivoDaConversa) {
        Paciente paciente = buscarPorId(pacienteId);
        Usuario usuario = usuarioService.buscarPorId(UsuarioLogadoUtil.getId());

        String conteudoConversa = extracaoTextoService.extrair(arquivoDaConversa);
        Conversa conversa = Conversa.novaConversa(conteudoConversa, paciente, usuario);

        paciente.adicionarConversa(conversa);

        return conversaRepository.save(conversa);
    }
}