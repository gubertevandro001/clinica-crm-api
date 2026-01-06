package com.gpa.clinica.crm.infrastructure.auth.model;

import com.gpa.clinica.crm.infrastructure.config.security.TokenResponse;

import java.time.LocalDateTime;

public record LoginResponse(
        String accessToken,
        String refreshToken,
        LocalDateTime issuedAt,
        LocalDateTime accessTokenExpiresAt,
        LocalDateTime refreshTokenExpiresAt
) {

    public static LoginResponse aPartirDe(TokenResponse tokenResponse) {
        return new LoginResponse(
                tokenResponse.accessToken(),
                tokenResponse.refreshToken(),
                tokenResponse.issuedAt(),
                tokenResponse.accessTokenExpiresAt(),
                tokenResponse.refreshTokenExpiresAt()
        );
    }
}
