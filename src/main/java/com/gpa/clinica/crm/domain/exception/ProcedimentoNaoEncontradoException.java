package com.gpa.clinica.crm.domain.exception;

public class ProcedimentoNaoEncontradoException extends EntidadeNaoEncontradaException {

    public ProcedimentoNaoEncontradoException(String procedimentoId) {
        super("Procedimento de id " + procedimentoId + " não encontrado!");
    }
}
