package com.gpa.clinica.crm.infrastructure.auth;

import com.gpa.clinica.crm.domain.entity.Usuario;
import com.gpa.clinica.crm.domain.repository.UsuarioRepository;
import com.gpa.clinica.crm.domain.valueobject.Role;
import com.gpa.clinica.crm.infrastructure.auth.model.RegisterRequest;
import com.gpa.clinica.crm.infrastructure.config.security.TokenResponse;
import com.gpa.clinica.crm.infrastructure.config.security.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthService {

    private final AuthenticationManager authManager;
    private final UsuarioRepository usuarioRepository;
    private final TokenService tokenService;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthService(AuthenticationManager authManager, UsuarioRepository usuarioRepository, TokenService tokenService, BCryptPasswordEncoder passwordEncoder) {
        this.authManager = authManager;
        this.usuarioRepository = usuarioRepository;
        this.tokenService = tokenService;
        this.passwordEncoder = passwordEncoder;
    }

    public TokenResponse login(String login, String senha) {
        Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(login, senha));

        UsuarioAuth usuario = (UsuarioAuth) auth.getPrincipal();

        return tokenService.obterToken(usuario);
    }

    public TokenResponse refresh(String refreshToken) {
        return tokenService.obterToken(refreshToken);
    }

    public void register(RegisterRequest registerRequest) {
        if (usuarioRepository.existsByEmail(registerRequest.email())) {
            throw new RuntimeException("Email já está em uso!");
        }
        if (usuarioRepository.existsByLogin(registerRequest.login())) {
            throw new RuntimeException("Login já está em uso!");
        }

        var usuario = Usuario.novoUsuario(
                registerRequest.nome(),
                registerRequest.cpf(),
                registerRequest.email(),
                registerRequest.login(),
                registerRequest.senha(),
                Role.ESTETICISTA
        );

        usuarioRepository.save(usuario);
    }
}

