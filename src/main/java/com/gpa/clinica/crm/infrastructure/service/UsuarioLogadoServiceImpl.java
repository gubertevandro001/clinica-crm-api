package com.gpa.clinica.crm.infrastructure.service;

import com.gpa.clinica.crm.domain.service.UsuarioLogadoService;
import com.gpa.clinica.crm.infrastructure.auth.LoggedUser;
import org.springframework.stereotype.Service;

@Service
public class UsuarioLogadoServiceImpl implements UsuarioLogadoService {

    @Override
    public String getId() {
        return LoggedUser.getId();
    }

    @Override
    public boolean ehAdministrador() {
        return LoggedUser.ehAdministrador();
    }
}
