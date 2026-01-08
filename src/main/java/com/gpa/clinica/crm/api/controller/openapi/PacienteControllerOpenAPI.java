package com.gpa.clinica.crm.api.controller.openapi;

import com.gpa.clinica.crm.api.model.CadastrarPacienteRequest;
import com.gpa.clinica.crm.api.model.CadastrarPacienteResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Pacientes", description = "Gerencia os pacientes")
public interface PacienteControllerOpenAPI {

    @PostMapping
    @Operation(summary = "Realiza o cadastro completo do paciente")
    @ApiResponse(responseCode = "201", description = "Paciente cadastrado com sucesso!")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public CadastrarPacienteResponse cadastrarPaciente(@RequestBody CadastrarPacienteRequest cadastrarPacienteRequest);
}
