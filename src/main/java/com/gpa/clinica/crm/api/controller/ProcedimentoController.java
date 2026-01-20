package com.gpa.clinica.crm.api.controller;

import com.gpa.clinica.crm.api.controller.openapi.ProcedimentoControllerOpenAPI;
import com.gpa.clinica.crm.api.model.request.CadastrarProcedimentoRequest;
import com.gpa.clinica.crm.api.model.response.ProcedimentoResponse;
import com.gpa.clinica.crm.domain.service.ProcedimentoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/procedimentos")
public class ProcedimentoController implements ProcedimentoControllerOpenAPI {

    private final ProcedimentoService procedimentoService;

    public ProcedimentoController(ProcedimentoService procedimentoService) {
        this.procedimentoService = procedimentoService;
    }

    @Override
    public ProcedimentoResponse cadastrarProcedimento(CadastrarProcedimentoRequest request) {
        return ProcedimentoResponse.aPartirDe(procedimentoService.cadastrar(request));
    }

    @Override
    public ProcedimentoResponse buscarProcedimentoPorId(String procedimentoId) {
        return ProcedimentoResponse.aPartirDe(procedimentoService.buscarPorId(procedimentoId));
    }

    @Override
    public List<ProcedimentoResponse> buscarTodosOsProcedimentos() {
        return procedimentoService.buscarTodos().stream()
                .map(ProcedimentoResponse::aPartirDe)
                .toList();

    }
}
