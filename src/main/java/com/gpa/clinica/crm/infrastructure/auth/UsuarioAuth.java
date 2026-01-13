package com.gpa.clinica.crm.infrastructure.auth;

import com.gpa.clinica.crm.domain.entity.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UsuarioAuth implements UserDetails {

    private final Usuario usuario;

    public UsuarioAuth(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getUsuarioId() {
        return usuario.getId();
    }

    @Override
    public String getUsername() {
        return usuario.getLogin();
    }

    @Override
    public String getPassword() {
        return usuario.getSenha();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public boolean isAccountNonLocked() {
        return usuario.isAtivo();
    }

    @Override
    public boolean isEnabled() {
        return usuario.isAtivo();
    }
}
