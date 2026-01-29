package com.gpa.clinica.crm.domain.service;

import com.gpa.clinica.crm.api.model.request.CadastrarAtendimentoRequest;
import com.gpa.clinica.crm.api.model.request.PageableAtendimentoRequest;
import com.gpa.clinica.crm.api.model.request.ProcedimentoIdRequest;
import com.gpa.clinica.crm.domain.entity.*;
import com.gpa.clinica.crm.domain.exception.AtendimentoNaoEncontradoException;
import com.gpa.clinica.crm.domain.repository.AtendimentoRepository;
import com.gpa.clinica.crm.infrastructure.spec.BuscaAtendimentosSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AtendimentoService {

    private final AtendimentoRepository atendimentoRepository;
    private final ProcedimentoService procedimentoService;
    private final PacienteService pacienteService;
    private final UsuarioService usuarioService;
    private final UsuarioLogadoService usuarioLogadoService;

    public AtendimentoService(AtendimentoRepository atendimentoRepository, ProcedimentoService procedimentoService,
                              PacienteService pacienteService, UsuarioService usuarioService, UsuarioLogadoService usuarioLogadoService) {
        this.atendimentoRepository = atendimentoRepository;
        this.procedimentoService = procedimentoService;
        this.pacienteService = pacienteService;
        this.usuarioService = usuarioService;
        this.usuarioLogadoService = usuarioLogadoService;
    }

    public Atendimento buscarPorId(String atendimentoId) {
        if (usuarioLogadoService.ehAdministrador()) {
            return buscarAtendimento(atendimentoId);
        }
        return buscarAtendimentoDoUsuario(atendimentoId, usuarioLogadoService.getId());
    }

    public Page<Atendimento> buscarPorFiltro(PageableAtendimentoRequest request) {
        Pageable pageable = PageRequest.of(request.numeroDaPagina() - 1, request.registrosPorPagina());

        var filtro = BuscaAtendimentosSpecification.buscarPor(
                usuarioLogadoService.ehAdministrador() ? null : usuarioLogadoService.getId(),
                request.nome(),
                request.dataInicio(),
                request.dataFim()
        );

        return atendimentoRepository.findAll(filtro, pageable);
    }

    @Transactional
    public Atendimento cadastrar(CadastrarAtendimentoRequest request) {
        Paciente paciente = pacienteService.buscarPorId(request.pacienteId());
        Usuario usuario = usuarioService.buscarPorId(usuarioLogadoService.getId());

        Atendimento atendimento = Atendimento.novoAtendimento(paciente, usuario);

        List<ProcedimentoAtendimento> procedimentos = criarProcedimentos(atendimento, request.procedimentos());

        atendimento.adicionarProcedimentos(procedimentos);

        return atendimentoRepository.save(atendimento);
    }

    public void adicionarProcedimento(String atendimentoId, String procedimentoId) {
        Atendimento atendimento = buscarPorId(atendimentoId);
        Procedimento procedimento = procedimentoService.buscarPorId(procedimentoId);
        atendimento.adicionarProcedimento(ProcedimentoAtendimento.novoProcedimentoAtendimento(atendimento, procedimento));

        atendimentoRepository.save(atendimento);
    }

    public void removerProcedimento(String atendimentoId, String procedimentoAtendimentoId) {
        Atendimento atendimento = buscarPorId(atendimentoId);
        atendimento.removerProcedimento(procedimentoAtendimentoId);

        atendimentoRepository.save(atendimento);
    }

    private List<ProcedimentoAtendimento> criarProcedimentos(Atendimento atendimento,
                                                             List<ProcedimentoIdRequest> procedimentos) {
        return procedimentos.stream().map(proc -> {
            Procedimento procedimento = procedimentoService.buscarPorId(proc.id());
            return ProcedimentoAtendimento.novoProcedimentoAtendimento(atendimento, procedimento);
        }).toList();
    }

    private Atendimento buscarAtendimento(String atendimentoId) {
        return atendimentoRepository.findById(atendimentoId)
                .orElseThrow(() -> new AtendimentoNaoEncontradoException(atendimentoId));
    }

    private Atendimento buscarAtendimentoDoUsuario(String atendimentoId, String usuarioId) {
        return atendimentoRepository.findByIdAndUsuarioId(atendimentoId, usuarioId)
                .orElseThrow(() -> new AtendimentoNaoEncontradoException(atendimentoId));
    }
}
