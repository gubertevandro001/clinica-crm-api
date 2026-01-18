package com.gpa.clinica.crm.infrastructure.auth.model;

import jakarta.validation.constraints.NotBlank;

public record RefreshRequest(
        @NotBlank
        String refreshToken
) {}
