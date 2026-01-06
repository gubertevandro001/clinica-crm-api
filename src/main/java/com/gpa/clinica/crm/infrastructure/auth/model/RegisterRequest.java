package com.gpa.clinica.crm.infrastructure.auth.model;

public record RegisterRequest(
        String nome,
        String cpf,
        String email,
        String login,
        String senha
) {}
