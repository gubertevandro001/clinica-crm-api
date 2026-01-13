package com.gpa.clinica.crm.domain.exception;

public class ExtracaoTextoException extends RuntimeException {

    public ExtracaoTextoException(Throwable cause) {
        super("Erro ao realizar extração do arquivo txt recebido", cause);
    }
}
