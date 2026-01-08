package com.gpa.clinica.crm.api.model;

public record AnamneseModel(
        HabitosDiariosModel habitosDiarios,
        HistoricoClinicoModel historicoClinico,
        TratamentoEsteticoCirurgicoModel tratamentoEsteticoCirurgico
) {}
