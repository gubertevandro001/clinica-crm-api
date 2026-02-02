package com.gpa.clinica.crm.domain.entity;

import com.gpa.clinica.crm.domain.util.IdGenerator;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "analise")
public class Analise {

    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(name = "conteudo")
    private String conteudo;

    @Column(name = "data_analise")
    private LocalDateTime dataAnalise;

    protected Analise() {}

    public Analise(Paciente paciente, Usuario usuario, String conteudo) {
        this.id = IdGenerator.generateId();
        this.paciente = paciente;
        this.usuario = usuario;
        this.conteudo = conteudo;
        this.dataAnalise = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDateTime getDataAnalise() {
        return dataAnalise;
    }

    public void setDataAnalise(LocalDateTime dataAnalise) {
        this.dataAnalise = dataAnalise;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Analise analise = (Analise) o;
        return Objects.equals(id, analise.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
