package com.gpa.clinica.crm.domain.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "procedimento_atendimento")
public class ProcedimentoAtendimento {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Atendimento atendimento;

    @ManyToOne
    @JoinColumn(name = "procedimento_id")
    private Procedimento procedimento;

    @Column(name = "valor")
    private BigDecimal valor;

    protected ProcedimentoAtendimento() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Atendimento getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProcedimentoAtendimento that = (ProcedimentoAtendimento) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
