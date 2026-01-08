package com.gpa.clinica.crm.api.model;

public record HistoricoClinicoModel(

        Boolean tratamentoMedicoAtual,
        String medicamentosEmUso,

        Boolean antecedentesAlergicos,
        String antecedentesAlergicosDescricao,

        Boolean portadorDeMarcapasso,

        Boolean alteracoesCardiacas,
        String alteracoesDescricao,

        Boolean hipertensaoArterial,

        Boolean disturbioCirculatorio,
        String disturbioCirculatorioDescricao,

        Boolean disturbioRenal,
        String disturbioRenalDescricao,

        Boolean disturbioHormonal,
        String disturbioHormonalDescricao,

        Boolean disturbioGastroIntestinal,
        String disturbioGastroIntestinalDescricao,

        Boolean epilepsiaConvulsoes,
        String epilepsiaConvulsoesDescricao,

        Boolean alteracoesPsicologicas,
        String alteracoesPsicologicasDescricao,

        Boolean extresse,
        String extresseDescricao,

        Boolean antecedentesOncologicos,
        String antecedentesOncologicosDescricao,

        Boolean diabetes,
        String tipoDiabetes,

        Boolean possuiDoenca,
        String doencaDescricao

) {}
