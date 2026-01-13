package com.gpa.clinica.crm.domain.exception;

public class PacienteNaoEncontradoException extends EntidadeNaoEncontradaException {

    public PacienteNaoEncontradoException(String pacienteId) {
        super("Paciente de id " + pacienteId + " não encontrado!");
    }
}
