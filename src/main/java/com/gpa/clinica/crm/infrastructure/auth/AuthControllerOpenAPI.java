package com.gpa.clinica.crm.infrastructure.auth;

import com.gpa.clinica.crm.infrastructure.auth.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Tag(name = "Autenticações", description = "Gerencia a autenticação e cadastro de usuários")
public interface AuthControllerOpenAPI {

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Realiza login do usuário")
    @ApiResponse(responseCode = "401", description = "Credenciais inválidas")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public LoginResponse login(@RequestBody @Valid LoginRequest loginRequest);

    @PostMapping("/refresh")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Realiza o refresh do login do usuário")
    @ApiResponse(responseCode = "401", description = "Token inválido")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public RefreshResponse refresh(@RequestBody @Valid RefreshRequest refreshRequest);

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Realiza o cadastro de um usuário")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public void register(@RequestBody @Valid RegisterRequest registerRequest);
}

