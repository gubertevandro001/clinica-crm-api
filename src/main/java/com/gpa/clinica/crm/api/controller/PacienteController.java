package com.gpa.clinica.crm.api.controller;

import com.gpa.clinica.crm.api.controller.openapi.PacienteControllerOpenAPI;
import com.gpa.clinica.crm.api.model.request.AtualizarPacienteRequest;
import com.gpa.clinica.crm.api.model.request.CadastrarPacienteRequest;
import com.gpa.clinica.crm.api.model.request.PageableRequest;
import com.gpa.clinica.crm.api.model.response.PacientePageableResponse;
import com.gpa.clinica.crm.api.model.response.PacienteResponse;
import com.gpa.clinica.crm.domain.service.PacienteService;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController implements PacienteControllerOpenAPI {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @Override
    public PacienteResponse buscarPacientePorId(String pacienteId) {
        return PacienteResponse.aPartirDe(pacienteService.buscarPorId(pacienteId));
    }

    @Override
    public PacientePageableResponse buscarPacientesPorFiltro(int pagina, int tamanho, String filtro) {
        return PacientePageableResponse.aPartirDe(pacienteService.buscarPorFiltro(
                new PageableRequest(filtro, pagina, tamanho)));
    }

    @Override
    public PacienteResponse cadastrarPaciente(CadastrarPacienteRequest cadastrarPacienteRequest) {
        return PacienteResponse.aPartirDe(pacienteService.cadastrar(cadastrarPacienteRequest));
    }

    @Override
    public PacienteResponse atualizarPaciente(String pacienteId, AtualizarPacienteRequest request) {
        return PacienteResponse.aPartirDe(pacienteService.atualizar(pacienteId, request));
    }
}
