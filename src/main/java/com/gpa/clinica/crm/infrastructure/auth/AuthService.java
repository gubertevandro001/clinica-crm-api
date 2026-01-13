package com.gpa.clinica.crm.infrastructure.auth;

import com.gpa.clinica.crm.domain.entity.Usuario;
import com.gpa.clinica.crm.domain.repository.UsuarioRepository;
import com.gpa.clinica.crm.infrastructure.auth.model.RegisterRequest;
import com.gpa.clinica.crm.infrastructure.auth.model.RegisterResponse;
import com.gpa.clinica.crm.infrastructure.config.security.TokenService;
import com.gpa.clinica.crm.infrastructure.config.security.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authManager;
    private final UsuarioRepository usuarioRepository;
    private final TokenService tokenService;
    private final BCryptPasswordEncoder passwordEncoder;

    public TokenResponse login(String login, String senha) {
        Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(login, senha));

        UsuarioAuth usuario = (UsuarioAuth) auth.getPrincipal();

        return tokenService.obterToken(usuario);
    }

    public TokenResponse refresh(String refreshToken) {
        return tokenService.obterToken(refreshToken);
    }

    public RegisterResponse register(RegisterRequest registerRequest) {
        if (usuarioRepository.existsByEmail(registerRequest.email())) {
            throw new RuntimeException("Email já está em uso!");
        }
        if (usuarioRepository.existsByLogin(registerRequest.login())) {
            throw new RuntimeException("Login já está em uso!");
        }

        var usuario = Usuario.builder()
                .id(UUID.randomUUID().toString())
                .nome(registerRequest.nome())
                .cpf(registerRequest.cpf())
                .email(registerRequest.email())
                .login(registerRequest.login())
                .senha(passwordEncoder.encode(registerRequest.senha()))
                .build();

        usuarioRepository.save(usuario);

        return new RegisterResponse(usuario.getId(), "Usuário registrado com sucesso!");
    }
}

