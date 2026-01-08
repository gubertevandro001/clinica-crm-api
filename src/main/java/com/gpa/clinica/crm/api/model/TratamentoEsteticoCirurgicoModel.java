package com.gpa.clinica.crm.api.model;

public record TratamentoEsteticoCirurgicoModel(

        Boolean implanteDentario,
        String implanteDentarioDescricao,

        Boolean tratamentoEstetico,
        String tratamentoEsteticoDescricao,

        Boolean cirurgiaPlastica,
        String cirurgiaPlasticaDescricao,

        Boolean cirurgiaRepadora,
        String cirurgiaReparadoraDescricao

) {}

