package com.gpa.clinica.crm.domain.util;

import com.gpa.clinica.crm.domain.entity.Usuario;
import com.gpa.clinica.crm.infrastructure.auth.UsuarioAuth;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public final class LoggedUser {

    public static String getId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        assert auth != null;
        var usuario = (UsuarioAuth) auth.getPrincipal();
        assert usuario != null;
        return usuario.getUsuarioId();
    }
}
