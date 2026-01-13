package com.gpa.clinica.crm.api.model.request;

import com.gpa.clinica.crm.domain.entity.Anamnese;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record AnamneseRequest(

        @Valid
        @NotNull
        HabitosDiariosRequest habitosDiarios,

        @Valid
        @NotNull
        HistoricoClinicoRequest historicoClinico,

        @Valid
        @NotNull
        TratamentoEsteticoCirurgicoRequest tratamentoEsteticoCirurgico
) {

    public static AnamneseRequest aPartirDe(Anamnese anamnese) {
        return new AnamneseRequest(
                HabitosDiariosRequest.aPartirDe(anamnese.getHabitosDiarios()),
                HistoricoClinicoRequest.aPartirDe(anamnese.getHistoricoClinico()),
                TratamentoEsteticoCirurgicoRequest.aPartirDe(anamnese.getTratamentoEsteticoCirurgico())
        );
    }
}
