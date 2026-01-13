package com.gpa.clinica.crm.api.model.request;

import com.gpa.clinica.crm.domain.valueobject.TratamentoEsteticoCirurgico;
import jakarta.validation.constraints.NotNull;

public record TratamentoEsteticoCirurgicoRequest(

        @NotNull
        Boolean implanteDentario,
        String implanteDentarioDescricao,

        @NotNull
        Boolean tratamentoEstetico,
        String tratamentoEsteticoDescricao,

        @NotNull
        Boolean cirurgiaPlastica,
        String cirurgiaPlasticaDescricao,

        @NotNull
        Boolean cirurgiaRepadora,
        String cirurgiaReparadoraDescricao

) {

    public static TratamentoEsteticoCirurgicoRequest aPartirDe(TratamentoEsteticoCirurgico tratamento) {
        return new TratamentoEsteticoCirurgicoRequest(
                tratamento.getImplanteDentario(),
                tratamento.getImplanteDentarioDescricao(),
                tratamento.getTratamentoEstetico(),
                tratamento.getTratamentoEsteticoDescricao(),
                tratamento.getCirurgiaPlastica(),
                tratamento.getCirurgiaPlasticaDescricao(),
                tratamento.getCirurgiaRepadora(),
                tratamento.getCirurgiaReparadoraDescricao()
        );
    }
}

