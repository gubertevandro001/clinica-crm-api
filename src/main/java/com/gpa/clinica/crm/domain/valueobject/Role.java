package com.gpa.clinica.crm.domain.valueobject;

public enum Role {

    ADMINISTRADOR("ROLE_ADMIN"),
    ESTETICISTA("ROLE_ESTETICISTA");

    private String nome;

    Role(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return nome;
    }
}
