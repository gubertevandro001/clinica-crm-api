package com.gpa.clinica.crm.domain.service;

import com.gpa.clinica.crm.api.model.request.CadastrarProcedimentoRequest;
import com.gpa.clinica.crm.domain.entity.Procedimento;
import com.gpa.clinica.crm.domain.exception.ProcedimentoNaoEncontradoException;
import com.gpa.clinica.crm.domain.mapper.ProcedimentoMapper;
import com.gpa.clinica.crm.domain.repository.ProcedimentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcedimentoService {

    private final ProcedimentoRepository procedimentoRepository;

    public ProcedimentoService(ProcedimentoRepository procedimentoRepository) {
        this.procedimentoRepository = procedimentoRepository;
    }

    public Procedimento cadastrar(CadastrarProcedimentoRequest request) {
        return procedimentoRepository.save(ProcedimentoMapper.criarProcedimento(request));
    }

    public Procedimento buscarPorId(String procedimentoId) {
        return procedimentoRepository.findById(procedimentoId).orElseThrow(
                () -> new ProcedimentoNaoEncontradoException(procedimentoId));
    }

    public List<Procedimento> buscarTodos() {
        return procedimentoRepository.findAll();
    }
}
