package com.gpa.clinica.crm.domain.entity;

import com.gpa.clinica.crm.domain.util.IdGenerator;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "conversa")
public class Conversa {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "conteudo")
    private String conteudo;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    protected Conversa() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
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

    private Conversa(String conteudo, Paciente paciente, Usuario usuario) {
        this.id = IdGenerator.generateId();
        this.conteudo = conteudo;
        this.paciente = paciente;
        this.usuario = usuario;
    }

    public static Conversa novaConversa(String conteudo, Paciente paciente, Usuario usuario) {
        return new Conversa(conteudo, paciente, usuario);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Conversa conversa = (Conversa) o;
        return Objects.equals(id, conversa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}