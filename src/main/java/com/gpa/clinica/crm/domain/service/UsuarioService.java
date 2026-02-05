package com.gpa.clinica.crm.domain.service;

import com.gpa.clinica.crm.domain.entity.Usuario;
import com.gpa.clinica.crm.domain.exception.UsuarioNaoEncontradoException;
import com.gpa.clinica.crm.domain.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioLogadoService usuarioLogadoService;

    public UsuarioService(UsuarioRepository usuarioRepository,  UsuarioLogadoService usuarioLogadoService) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioLogadoService = usuarioLogadoService;
    }

    public Usuario buscarPorId(String id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new UsuarioNaoEncontradoException(id));
    }

    public Usuario buscarUsuarioLogado() {
        return usuarioRepository.findById(usuarioLogadoService.getId())
                .orElseThrow(() -> new UsuarioNaoEncontradoException(usuarioLogadoService.getId()));
    }
}
