package com.gpa.clinica.crm.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "documento")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Conversa {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id")
    private String id;

    @Column(name = "conteudo")
    private String conteudo;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
}