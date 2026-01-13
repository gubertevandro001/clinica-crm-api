package com.gpa.clinica.crm.domain.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public final class LoggedUser {

    public static String getId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        assert auth != null;
        return auth.getName();
    }
}
