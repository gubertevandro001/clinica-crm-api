package com.gpa.clinica.crm.domain.entity;

import com.gpa.clinica.crm.domain.util.IdGenerator;
import com.gpa.clinica.crm.domain.valueobject.Contato;
import com.gpa.clinica.crm.domain.valueobject.Endereco;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "idade")
    private Integer idade;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "profissao")
    private String profissao;

    @Column(name = "estado_civil")
    private String estadoCivil;

    @Embedded
    private Endereco endereco;

    @Embedded
    private Contato contato;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "anamnese_id")
    private Anamnese anamnese;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Conversa> conversas = new ArrayList<>();

    @OneToMany(mappedBy = "paciente",  cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Analise>  analises = new ArrayList<>();

    protected Paciente() {}

    public Paciente(String nome, String cpf, Integer idade, LocalDate dataNascimento,
                    String profissao, String estadoCivil, Endereco endereco, Contato contato, Anamnese anamnese) {
        this.id = IdGenerator.generateId();
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.dataNascimento = dataNascimento;
        this.profissao = profissao;
        this.estadoCivil = estadoCivil;
        this.endereco = endereco;
        this.contato = contato;
        this.anamnese = anamnese;
    }

    public Paciente atualizar(String nome, Integer idade, LocalDate dataNascimento, String profissao,
                              String estadoCivil, Endereco endereco, Contato contato, String anotacoesAnamnese) {
        this.nome = nome;
        this.idade = idade;
        this.dataNascimento = dataNascimento;
        this.profissao = profissao;
        this.estadoCivil = estadoCivil;
        this.endereco = endereco;
        this.contato = contato;
        this.anamnese.atualizarAnotacoes(anotacoesAnamnese);
        return this;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Integer getIdade() {
        return idade;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getProfissao() {
        return profissao;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Contato getContato() {
        return contato;
    }

    public Anamnese getAnamnese() {
        return anamnese;
    }

    public List<Conversa> getConversas() {
        return Collections.unmodifiableList(conversas);
    }

    public List<Analise> getAnalises() {
        return Collections.unmodifiableList(analises);
    }

    public void adicionarConversa(Conversa conversa){
        conversas.add(conversa);
    }

    public void adicionarAnalise(Analise analise){
        getAnalises().add(analise);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(id, paciente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
