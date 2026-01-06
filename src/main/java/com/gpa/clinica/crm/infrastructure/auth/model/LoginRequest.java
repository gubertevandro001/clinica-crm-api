package com.gpa.clinica.crm.infrastructure.auth.model;

public record LoginRequest(
        String login,
        String senha
) {}
