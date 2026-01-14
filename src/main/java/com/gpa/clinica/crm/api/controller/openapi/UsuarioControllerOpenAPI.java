package com.gpa.clinica.crm.api.controller.openapi;

import com.gpa.clinica.crm.api.model.response.UsuarioLogadoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;

@Tag(name = "Usuários", description = "Gerencia os usuários do sistema")
public interface UsuarioControllerOpenAPI {

    @GetMapping
    @Operation(summary = "Realiza a busca de dados do usuário logado")
    @ApiResponse(responseCode = "200", description = "Dados do usuário retornados com sucesso!")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public UsuarioLogadoResponse buscarUsuarioLogado();
}
