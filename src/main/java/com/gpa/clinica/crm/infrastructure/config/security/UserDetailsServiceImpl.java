package com.gpa.clinica.crm.infrastructure.config.security;

import com.gpa.clinica.crm.domain.model.Usuario;
import com.gpa.clinica.crm.domain.repository.UsuarioRepository;
import com.gpa.clinica.crm.infrastructure.auth.UsuarioAuth;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String login) {
        Usuario usuario = usuarioRepository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        return new UsuarioAuth(usuario);
    }
}
