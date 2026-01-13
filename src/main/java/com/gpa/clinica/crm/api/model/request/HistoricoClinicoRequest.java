package com.gpa.clinica.crm.api.model.request;

import com.gpa.clinica.crm.domain.valueobject.HistoricoClinico;
import jakarta.validation.constraints.NotNull;

public record HistoricoClinicoRequest(

        @NotNull
        Boolean tratamentoMedicoAtual,
        String medicamentosEmUso,

        @NotNull
        Boolean antecedentesAlergicos,
        String antecedentesAlergicosDescricao,

        @NotNull
        Boolean portadorDeMarcapasso,

        @NotNull
        Boolean alteracoesCardiacas,
        String alteracoesDescricao,

        @NotNull
        Boolean hipertensaoArterial,

        @NotNull
        Boolean disturbioCirculatorio,
        String disturbioCirculatorioDescricao,

        @NotNull
        Boolean disturbioRenal,
        String disturbioRenalDescricao,

        @NotNull
        Boolean disturbioHormonal,
        String disturbioHormonalDescricao,

        @NotNull
        Boolean disturbioGastroIntestinal,
        String disturbioGastroIntestinalDescricao,

        @NotNull
        Boolean epilepsiaConvulsoes,
        String epilepsiaConvulsoesDescricao,

        @NotNull
        Boolean alteracoesPsicologicas,
        String alteracoesPsicologicasDescricao,

        @NotNull
        Boolean extresse,
        String extresseDescricao,

        @NotNull
        Boolean antecedentesOncologicos,
        String antecedentesOncologicosDescricao,

        @NotNull
        Boolean diabetes,
        String tipoDiabetes,

        @NotNull
        Boolean possuiDoenca,
        String doencaDescricao

) {

    public static HistoricoClinicoRequest aPartirDe(HistoricoClinico historicoClinico) {
        return new HistoricoClinicoRequest(
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
