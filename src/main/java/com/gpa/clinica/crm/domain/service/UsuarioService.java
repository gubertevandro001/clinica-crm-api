package com.gpa.clinica.crm.domain.service;

import com.gpa.clinica.crm.domain.model.Paciente;
import com.gpa.clinica.crm.domain.model.Usuario;
import com.gpa.clinica.crm.domain.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario buscarPorId(String  id){
        return usuarioRepository.findById(id).orElse(null);
    }
}
