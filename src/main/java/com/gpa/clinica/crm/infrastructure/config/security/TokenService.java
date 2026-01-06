package com.gpa.clinica.crm.infrastructure.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.gpa.clinica.crm.infrastructure.auth.UsuarioAuth;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class TokenService {

    @Value("${api.security.jwt.secret-key}")
    private String secretKey;

    @Value("${api.security.jwt.issuer}")
    private String issuer;

    private final UserDetailsService userDetailsService;

    public TokenResponse obterToken(UsuarioAuth usuario) {
        var dataExpiracaoToken = getExpirationDate();

        return new TokenResponse(
                gerarToken(usuario, dataExpiracaoToken),
                gerarToken(usuario, dataExpiracaoToken.plusHours(4)),
                LocalDateTime.now(),
                dataExpiracaoToken,
                dataExpiracaoToken.plusHours(4)
        );
    }

    public TokenResponse obterToken(String refreshToken) {
        String login = validarToken(refreshToken);

        var usuario = userDetailsService.loadUserByUsername(login);

        var authentication = new UsernamePasswordAuthenticationToken(usuario, null, null);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return obterToken((UsuarioAuth) usuario);
    }

    public String gerarToken(UsuarioAuth usuario, LocalDateTime dataExpiracao) {
        return JWT.create()
                .withIssuer(issuer)
                .withClaim("nome", usuario.getUsuario().getNome())
                .withClaim("email", usuario.getUsuario().getEmail())
                .withClaim("login", usuario.getUsuario().getLogin())
                .withSubject(usuario.getUsuarioId())
                .withExpiresAt(Date.from(dataExpiracao.atZone(ZoneId.systemDefault()).toInstant()))
                .sign(Algorithm.HMAC256(secretKey));
    }

    public String validarToken(String token) {
        return JWT.require(Algorithm.HMAC256(secretKey))
                .withIssuer(issuer)
                .build()
                .verify(token)
                .getClaim("login").asString();
    }

    private LocalDateTime getExpirationDate() {
        return LocalDateTime.now().plusHours(8);
    }
}

