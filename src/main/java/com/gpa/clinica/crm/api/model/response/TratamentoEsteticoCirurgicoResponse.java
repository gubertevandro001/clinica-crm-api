package com.gpa.clinica.crm.api.model.response;

import com.gpa.clinica.crm.domain.valueobject.TratamentoEsteticoCirurgico;

public record TratamentoEsteticoCirurgicoResponse(

        Boolean implanteDentario,
        String implanteDentarioDescricao,

        Boolean tratamentoEstetico,
        String tratamentoEsteticoDescricao,

        Boolean cirurgiaPlastica,
        String cirurgiaPlasticaDescricao,

        Boolean cirurgiaRepadora,
        String cirurgiaReparadoraDescricao

) {

    public static TratamentoEsteticoCirurgicoResponse aPartirDe(TratamentoEsteticoCirurgico tratamento) {
        return new TratamentoEsteticoCirurgicoResponse(
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

