package com.gpa.clinica.crm.api.controller.openapi;

import com.gpa.clinica.crm.api.model.request.CadastrarAtendimentoRequest;
import com.gpa.clinica.crm.api.model.response.AtendimentoPageableResponse;
import com.gpa.clinica.crm.api.model.response.AtendimentoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Tag(name = "Atendimentos", description = "Gerencia os atendimentos")
public interface AtendimentoControllerOpenAPI {

    @PostMapping
    @Operation(summary = "Realiza o cadastro de um atendimento")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponse(responseCode = "201", description = "Atendimento cadastrado com sucesso!")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public AtendimentoResponse cadastrarAtendimento(@RequestBody @Valid CadastrarAtendimentoRequest request);

    @GetMapping("/{atendimentoId}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Realiza a busca de um atendimento pelo id")
    @ApiResponse(responseCode = "200", description = "Atendimento retornado com sucesso!")
    @ApiResponse(responseCode = "404", description = "Atendimento não encontrado")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public AtendimentoResponse buscarAtendimentoPorId(@PathVariable("atendimentoId") String atendimentoId);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Realiza a busca de atendimentos a partir dos filtros passados")
    @ApiResponse(responseCode = "200", description = "Atendimentos retornados com sucesso!")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public AtendimentoPageableResponse buscarAtendimentosPorFiltro(@RequestParam(defaultValue = "1") int pagina,
                                                                   @RequestParam(defaultValue = "20") int tamanho,
                                                                   @RequestParam(required = false) String nome,
                                                                   @RequestParam(required = false)
                                                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                                   LocalDate dataInicio,
                                                                   @RequestParam(required = false)
                                                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                                   LocalDate dataFim);

    @PutMapping("/{atendimentoId}/procedimentos/{procedimentoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Adiciona um procedimento no atendimento existente")
    @ApiResponse(responseCode = "204", description = "Procediemento adicionado ao atendimento!")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public void adicionarProcedimento(@PathVariable("atendimentoId") String atendimentoId,
                                      @PathVariable("procedimentoId") String procedimentoId);

    @DeleteMapping("/{atendimentoId}/procedimentos/{procedimentoAtendimentoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Remove um procedimento do atendimento existente")
    @ApiResponse(responseCode = "204", description = "Procediemento removido do atendimento!")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public void removerProcedimento(@PathVariable("atendimentoId") String atendimentoId,
                                    @PathVariable("procedimentoAtendimentoId") String procedimentoId);
}
