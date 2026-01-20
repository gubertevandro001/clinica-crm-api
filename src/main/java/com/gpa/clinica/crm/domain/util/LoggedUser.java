package com.gpa.clinica.crm.domain.util;

import com.gpa.clinica.crm.domain.valueobject.Role;
import com.gpa.clinica.crm.infrastructure.auth.UsuarioAuth;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LoggedUser {

    public static String getId() {
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .filter(Authentication::isAuthenticated)
                .map(Authentication::getPrincipal)
                .filter(UsuarioAuth.class::isInstance)
                .map(UsuarioAuth.class::cast)
                .map(UsuarioAuth::getUsuarioId)
                .orElse(null);
    }

    public static Role getRole() {
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .filter(Authentication::isAuthenticated)
                .map(Authentication::getPrincipal)
                .filter(UsuarioAuth.class::isInstance)
                .map(UsuarioAuth.class::cast)
                .map(UsuarioAuth::getRole)
                .orElse(null);
    }

    public static boolean ehAdministrador() {
        return getRole() == Role.ADMINISTRADOR;
    }
}
