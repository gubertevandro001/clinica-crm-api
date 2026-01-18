package com.gpa.clinica.crm.domain.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "procedimento")
public class Procedimento {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "valor")
    private String valor;

    protected Procedimento() {}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Procedimento that = (Procedimento) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
