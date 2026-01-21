package com.gpa.clinica.crm.api.controller.openapi;

import com.gpa.clinica.crm.api.model.request.AtualizarPacienteRequest;
import com.gpa.clinica.crm.api.model.request.CadastrarPacienteRequest;
import com.gpa.clinica.crm.api.model.response.PacientePageableResponse;
import com.gpa.clinica.crm.api.model.response.PacienteResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Pacientes", description = "Gerencia os pacientes")
public interface PacienteControllerOpenAPI {

    @GetMapping("/{pacienteId}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Realiza a busca de um paciente pelo id")
    @ApiResponse(responseCode = "200", description = "Paciente retornado com sucesso!")
    @ApiResponse(responseCode = "404", description = "Paciente não encontrado")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public PacienteResponse buscarPacientePorId(@PathVariable("pacienteId") String pacienteId);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Realiza a busca de pacientes a partir dos filtros passados")
    @ApiResponse(responseCode = "200", description = "Pacientes retornados com sucesso!")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public PacientePageableResponse buscarPacientesPorFiltro(@RequestParam(defaultValue = "1") int pagina,
                                                                   @RequestParam(defaultValue = "20") int tamanho,
                                                                   @RequestParam(required = false) String filtro);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Realiza o cadastro completo do paciente")
    @ApiResponse(responseCode = "201", description = "Paciente cadastrado com sucesso!")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public PacienteResponse cadastrarPaciente(@RequestBody @Valid CadastrarPacienteRequest cadastrarPacienteRequest);

    @PutMapping("/{pacienteId}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Realiza a atualização do cadastro do paciente")
    @ApiResponse(responseCode = "200", description = "Paciente atualizado com sucesso!")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public PacienteResponse atualizarPaciente(@PathVariable("pacienteId") String pacienteId,
                                              @RequestBody @Valid AtualizarPacienteRequest request);
}
