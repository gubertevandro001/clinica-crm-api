package com.gpa.clinica.crm.api.model.response;

import com.gpa.clinica.crm.domain.valueobject.HistoricoClinico;

public record HistoricoClinicoResponse(

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

) {

    public static HistoricoClinicoResponse aPartirDe(HistoricoClinico historicoClinico) {
        return new HistoricoClinicoResponse(
                historicoClinico.getTratamentoMedicoAtual(),
                historicoClinico.getMedicamentosEmUso(),
                historicoClinico.getAntecedentesAlergicos(),
                historicoClinico.getAntecedentesAlergicosDescricao(),
                historicoClinico.getPortadorDeMarcapasso(),
                historicoClinico.getAlteracoesCardiacas(),
                historicoClinico.getAlteracoesDescricao(),
                historicoClinico.getHipertensaoArterial(),
                historicoClinico.getDisturbioCirculatorio(),
                historicoClinico.getDisturbioCirculatorioDescricao(),
                historicoClinico.getDisturbioRenal(),
                historicoClinico.getDisturbioRenalDescricao(),
                historicoClinico.getDisturbioHormonal(),
                historicoClinico.getDisturbioHormonalDescricao(),
                historicoClinico.getDisturbioGastroIntestinal(),
                historicoClinico.getDisturbioGastroIntestinalDescricao(),
                historicoClinico.getEpilepsiaConvulsoes(),
                historicoClinico.getEpilepsiaConvulsoesDescricao(),
                historicoClinico.getAlteracoesPsicologicas(),
                historicoClinico.getAlteracoesPsicologicasDescricao(),
                historicoClinico.getExtresse(),
                historicoClinico.getExtresseDescricao(),
                historicoClinico.getAntecedentesOncologicos(),
                historicoClinico.getAntecedentesOncologicosDescricao(),
                historicoClinico.getDiabetes(),
                historicoClinico.getTipoDiabetes(),
                historicoClinico.getPossuiDoenca(),
                historicoClinico.getDoencaDescricao()
        );
    }
}
