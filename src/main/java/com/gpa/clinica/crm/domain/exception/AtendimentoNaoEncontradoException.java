package com.gpa.clinica.crm.domain.exception;

public class AtendimentoNaoEncontradoException extends EntidadeNaoEncontradaException {

    public AtendimentoNaoEncontradoException(String atendimentoId) {
        super("Atendimento de id " + atendimentoId + " não encontrado!");
    }
}
