package com.gpa.clinica.crm.domain.entity;

import com.gpa.clinica.crm.domain.util.IdGenerator;
import com.gpa.clinica.crm.domain.valueobject.HabitosDiarios;
import com.gpa.clinica.crm.domain.valueobject.HistoricoClinico;
import com.gpa.clinica.crm.domain.valueobject.TratamentoEsteticoCirurgico;
import jakarta.persistence.*;
import org.springframework.util.StringUtils;

import java.util.Objects;

@Entity
@Table(name = "anamnese")
public class Anamnese {

    @Id
    @Column(name = "id")
    private String id;

    @Embedded
    private HabitosDiarios habitosDiarios;

    @Embedded
    private HistoricoClinico historicoClinico;

    @Embedded
    private TratamentoEsteticoCirurgico tratamentoEsteticoCirurgico;

    public Anamnese() {}

    public Anamnese(HabitosDiarios habitosDiarios, HistoricoClinico historicoClinico,
                    TratamentoEsteticoCirurgico tratamentoEsteticoCirurgico) {
        this.id = IdGenerator.generateId();
        this.habitosDiarios = habitosDiarios;
        this.historicoClinico = historicoClinico;
        this.tratamentoEsteticoCirurgico = tratamentoEsteticoCirurgico;
    }

    public void atualizarAnotacoes(String anotacoes) {
        if (StringUtils.hasText(anotacoes)) {
            this.habitosDiarios.setAnotacoes(anotacoes);
        }
    }

    public String getId() {
        return id;
    }

    public HabitosDiarios getHabitosDiarios() {
        return habitosDiarios;
    }

    public HistoricoClinico getHistoricoClinico() {
        return historicoClinico;
    }

    public TratamentoEsteticoCirurgico getTratamentoEsteticoCirurgico() {
        return tratamentoEsteticoCirurgico;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Anamnese anamnese = (Anamnese) o;
        return Objects.equals(id, anamnese.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
