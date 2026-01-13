package com.gpa.clinica.crm.api.model.request;

import com.gpa.clinica.crm.domain.valueobject.HabitosDiarios;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record HabitosDiariosRequest(

        @NotNull
        Boolean tratamentoEsteticoAnterior,

        String tratamentoEsteticoDescricao,

        @NotNull
        Boolean usaLentesDeContato,
        @NotNull
        Boolean utilizaComesticos,
        String cosmeticosDescricao,

        @NotNull
        Boolean exposicaoSolar,
        @NotNull
        Boolean usaFiltroSolar,
        String frequenciaFiltroSolar,

        @NotNull
        Boolean tabagismo,
        Integer quantidadeCigarrosDia,

        @NotNull
        Boolean ingereBebidaAlcoolica,
        String frequenciaBebidaAlcoolica,

        @NotBlank
        String funcionamentoIntestinal,

        @NotNull
        Boolean qualidadeSono,
        @NotNull
        Integer horasSono,

        @NotNull
        Integer ingestaoAguaCoposDia,

        @NotBlank
        String qualidadeAlimentacao,
        String alimentosPreferencia,

        @NotNull
        Boolean praticaAtividadeFisica,
        String tipoAtividadeFisica,
        String frequenciaAtividadeFisica,

        @NotNull
        Boolean usaAnticoncepcional,
        String anticonsepcionalDescricao,

        String dataPrimeiroDiaUltimaMenstruacao,

        @NotNull
        Boolean gestante,
        @NotNull
        Boolean gestacoes,
        @NotNull
        Integer quantidadeGestacoes,
        String tempoGestacao,

        String anotacoes
) {

    public static HabitosDiariosRequest aPartirDe(HabitosDiarios habitosDiarios) {
        return new HabitosDiariosRequest(
                habitosDiarios.getTratamentoEsteticoAnterior(),
                habitosDiarios.getTratamentoEsteticoDescricao(),
                habitosDiarios.getUsaLentesDeContato(),
                habitosDiarios.getUtilizaComesticos(),
                habitosDiarios.getCosmeticosDescricao(),
                habitosDiarios.getExposicaoSolar(),
                habitosDiarios.getUsaFiltroSolar(),
                habitosDiarios.getFrequenciaFiltroSolar(),
                habitosDiarios.getTabagismo(),
                habitosDiarios.getQuantidadeCigarrosDia(),
                habitosDiarios.getIngereBebidaAlcoolica(),
                habitosDiarios.getFrequenciaBebidaAlcoolica(),
                habitosDiarios.getFuncionamentoIntestinal(),
                habitosDiarios.getQualidadeSono(),
                habitosDiarios.getHorasSono(),
                habitosDiarios.getIngestaoAguaCoposDia(),
                habitosDiarios.getQualidadeAlimentacao(),
                habitosDiarios.getAlimentosPreferencia(),
                habitosDiarios.getPraticaAtividadeFisica(),
                habitosDiarios.getTipoAtividadeFisica(),
                habitosDiarios.getFrequenciaAtividadeFisica(),
                habitosDiarios.getUsaAnticoncepcional(),
                habitosDiarios.getAnticonsepcionalDescricao(),
                habitosDiarios.getDataPrimeiroDiaUltimaMenstruacao(),
                habitosDiarios.getGestante(),
                habitosDiarios.getGestacoes(),
                habitosDiarios.getQuantidadeGestacoes(),
                habitosDiarios.getTempoGestacao(),
                habitosDiarios.getAnotacoes()
        );
    }
}

