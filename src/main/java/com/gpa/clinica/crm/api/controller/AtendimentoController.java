package com.gpa.clinica.crm.api.controller;

import com.gpa.clinica.crm.api.controller.openapi.AtendimentoControllerOpenAPI;
import com.gpa.clinica.crm.api.model.request.CadastrarAtendimentoRequest;
import com.gpa.clinica.crm.api.model.request.PageableAtendimentoRequest;
import com.gpa.clinica.crm.api.model.response.AtendimentoPageableResponse;
import com.gpa.clinica.crm.api.model.response.AtendimentoResponse;
import com.gpa.clinica.crm.domain.service.AtendimentoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/atendimentos")
public class AtendimentoController implements AtendimentoControllerOpenAPI {

    private final AtendimentoService atendimentoService;

    public AtendimentoController(AtendimentoService atendimentoService) {
        this.atendimentoService = atendimentoService;
    }

    @Override
    public AtendimentoResponse cadastrarAtendimento(CadastrarAtendimentoRequest request) {
        return AtendimentoResponse.aPartirDe(atendimentoService.cadastrar(request));
    }

    @Override
    public AtendimentoResponse buscarAtendimentoPorId(String atendimentoId) {
        return AtendimentoResponse.aPartirDe(atendimentoService.buscarPorId(atendimentoId));
    }

    @Override
    public AtendimentoPageableResponse buscarAtendimentosPorFiltro(int pagina, int tamanho, String nome,
                                                                   LocalDate dataInicio, LocalDate dataFim) {
        return AtendimentoPageableResponse.aPartirDe(atendimentoService.buscarPorFiltro(
                new PageableAtendimentoRequest(nome, dataInicio, dataFim, pagina, tamanho)
        ));
    }
}
