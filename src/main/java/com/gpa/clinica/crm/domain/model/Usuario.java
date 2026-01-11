package com.gpa.clinica.crm.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuario")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id")
    private String id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "email")
    private String email;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String senha;

    @Column(name = "ativo")
    private boolean ativo;
}
