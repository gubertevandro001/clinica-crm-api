package com.gpa.clinica.crm.api.controller.openapi;

import com.gpa.clinica.crm.api.model.request.CadastrarProcedimentoRequest;
import com.gpa.clinica.crm.api.model.response.ProcedimentoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Procedimentos", description = "Gerencia os procedimentos")
public interface ProcedimentoControllerOpenAPI {

    @PostMapping
    @Operation(summary = "Realiza o cadastro de um procedimento")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponse(responseCode = "201", description = "Procedimento cadastrado com sucesso!")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public ProcedimentoResponse cadastrarProcedimento(@RequestBody @Valid CadastrarProcedimentoRequest request);

    @GetMapping("/{procedimentoId}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Realiza a busca de um procedimento pelo id")
    @ApiResponse(responseCode = "200", description = "Procedimento retornado com sucesso!")
    @ApiResponse(responseCode = "404", description = "Procedimento não encontrado")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public ProcedimentoResponse buscarProcedimentoPorId(@PathVariable("procedimentoId") String procedimentoId);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Realiza a busca de todos os procedimentos cadastrados no sistema")
    @ApiResponse(responseCode = "200", description = "Procedimentos retornados com sucesso!")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public List<ProcedimentoResponse> buscarTodosOsProcedimentos();
}
