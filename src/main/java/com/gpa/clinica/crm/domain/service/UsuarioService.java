package com.gpa.clinica.crm.domain.service;

import com.gpa.clinica.crm.domain.exception.UsuarioNaoEncontradoException;
import com.gpa.clinica.crm.domain.entity.Usuario;
import com.gpa.clinica.crm.domain.repository.UsuarioRepository;
import com.gpa.clinica.crm.infrastructure.auth.LoggedUser;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario buscarPorId(String id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new UsuarioNaoEncontradoException(id));
    }

    public Usuario buscarUsuarioLogado() {
        return usuarioRepository.findById(LoggedUser.getId())
                .orElseThrow(() -> new UsuarioNaoEncontradoException(LoggedUser.getId()));
    }
}
