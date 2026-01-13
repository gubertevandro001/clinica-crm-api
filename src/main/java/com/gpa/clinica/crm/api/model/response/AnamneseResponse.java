package com.gpa.clinica.crm.api.model.response;

import com.gpa.clinica.crm.domain.entity.Anamnese;

public record AnamneseResponse(
        HabitosDiariosResponse habitosDiarios,
        HistoricoClinicoResponse historicoClinico,
        TratamentoEsteticoCirurgicoResponse tratamentoEsteticoCirurgico
) {

    public static AnamneseResponse aPartirDe(Anamnese anamnese) {
        return new AnamneseResponse(
                HabitosDiariosResponse.aPartirDe(anamnese.getHabitosDiarios()),
                HistoricoClinicoResponse.aPartirDe(anamnese.getHistoricoClinico()),
                TratamentoEsteticoCirurgicoResponse.aPartirDe(anamnese.getTratamentoEsteticoCirurgico())
        );
    }
}
