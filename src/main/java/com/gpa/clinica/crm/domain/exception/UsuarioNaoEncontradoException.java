package com.gpa.clinica.crm.domain.exception;

public class UsuarioNaoEncontradoException extends EntidadeNaoEncontradaException {

    public UsuarioNaoEncontradoException(String usuarioId) {
        super("Usuário de id " + usuarioId + " não encontrado!");
    }
}
