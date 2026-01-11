package com.gpa.clinica.crm.domain.model;

import com.gpa.clinica.crm.domain.util.IdGenerator;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.util.StringUtils;

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

    public Anamnese(HabitosDiarios habitosDiarios, HistoricoClinico historicoClinico,
                    TratamentoEsteticoCirurgico tratamentoEsteticoCirurgico) {
        this.id = IdGenerator.generateId();
        this.habitosDiarios = habitosDiarios;
        this.historicoClinico = historicoClinico;
        this.tratamentoEsteticoCirurgico = tratamentoEsteticoCirurgico;
    }

    public Anamnese atualizarAnotacoes(String anotacoes) {
        if (StringUtils.hasText(anotacoes)) {
            this.habitosDiarios.setAnotacoes(anotacoes);
        }
        return this;
    }
}
