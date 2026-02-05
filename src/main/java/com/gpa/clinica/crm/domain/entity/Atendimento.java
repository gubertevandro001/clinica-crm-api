package com.gpa.clinica.crm.domain.entity;

import com.gpa.clinica.crm.domain.util.IdGenerator;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "atendimento")
public class Atendimento {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "data_atendimento")
    private LocalDate dataAtendimento;

    @Column(name = "valor")
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "atendimento", cascade = CascadeType.ALL)
    private List<ProcedimentoAtendimento> procedimentos = new ArrayList<>();

    protected Atendimento() {}

    private Atendimento(Paciente paciente, Usuario usuario) {
        this.id = IdGenerator.generateId();
        this.codigo = IdGenerator.generateCode();
        this.dataAtendimento = LocalDate.now();
        this.paciente = paciente;
        this.valor = BigDecimal.ZERO;
        this.usuario = usuario;
    }

    public static Atendimento novoAtendimento(Paciente paciente, Usuario usuario) {
        return new Atendimento(paciente, usuario);
    }

    public void adicionarProcedimentos(List<ProcedimentoAtendimento> procedimentos) {
        this.procedimentos.addAll(procedimentos);
        calcularValor();
    }

    public void calcularValor() {
        this.valor = this.procedimentos.stream()
                .map(ProcedimentoAtendimento::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Atendimento that = (Atendimento) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public String getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public LocalDate getDataAtendimento() {
        return dataAtendimento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public List<ProcedimentoAtendimento> getProcedimentos() {
        return procedimentos;
    }
}
