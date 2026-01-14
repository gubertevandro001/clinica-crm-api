package com.gpa.clinica.crm.api.controller;

import com.gpa.clinica.crm.api.controller.openapi.UsuarioControllerOpenAPI;
import com.gpa.clinica.crm.api.model.response.UsuarioLogadoResponse;
import com.gpa.clinica.crm.domain.service.UsuarioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController implements UsuarioControllerOpenAPI {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    public UsuarioLogadoResponse buscarUsuarioLogado() {
        return UsuarioLogadoResponse.aPartirDe(usuarioService.buscarUsuarioLogado());
    }
}
