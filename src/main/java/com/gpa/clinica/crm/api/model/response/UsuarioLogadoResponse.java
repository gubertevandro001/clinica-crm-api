package com.gpa.clinica.crm.api.model.response;

import com.gpa.clinica.crm.domain.entity.Usuario;

public record UsuarioLogadoResponse(
        String id,
        String nome,
        String email,
        String cpf,
        String role,
        String login,
        String senha
) {

    public static UsuarioLogadoResponse aPartirDe(Usuario usuario) {
        return new UsuarioLogadoResponse(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getCpf(),
                usuario.getRole().getDescricao(),
                usuario.getLogin(),
                usuario.getSenha()
        );
    }
}
