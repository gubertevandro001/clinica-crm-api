package com.gpa.clinica.crm.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "anamnese")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Anamnese {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "id")
    private String id;

    @Embedded
    private HabitosDiarios habitosDiarios;

    @Embedded
    private HistoricoClinico historicoClinico;

    @Embedded
    private TratamentoEsteticoCirurgico tratamentoEsteticoCirurgico;
}
