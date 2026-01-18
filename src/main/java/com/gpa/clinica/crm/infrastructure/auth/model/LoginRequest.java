package com.gpa.clinica.crm.infrastructure.auth.model;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        @NotBlank
        String login,

        @NotBlank
        String senha
) {}
