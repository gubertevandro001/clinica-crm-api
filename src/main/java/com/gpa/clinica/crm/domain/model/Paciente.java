package com.gpa.clinica.crm.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "paciente")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {

    @Id
    @EqualsAndHashCode.Include
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
    private DadosContato contato;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "anamnese_id")
    private Anamnese anamnese;

    @OneToMany(mappedBy = "paciente")
    private List<Conversa> conversas;
}
