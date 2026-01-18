package com.gpa.clinica.crm.infrastructure.auth.model;

import jakarta.validation.constraints.NotBlank;

public record RegisterRequest(

        @NotBlank
        String nome,

        @NotBlank
        String cpf,

        @NotBlank
        String email,

        @NotBlank
        String login,

        @NotBlank
        String senha
) {}
