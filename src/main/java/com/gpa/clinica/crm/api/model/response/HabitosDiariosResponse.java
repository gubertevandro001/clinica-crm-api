package com.gpa.clinica.crm.api.model.response;

import com.gpa.clinica.crm.domain.valueobject.HabitosDiarios;

public record HabitosDiariosResponse(

        Boolean tratamentoEsteticoAnterior,
        String tratamentoEsteticoDescricao,

        Boolean usaLentesDeContato,
        Boolean utilizaComesticos,
        String cosmeticosDescricao,

        Boolean exposicaoSolar,
        Boolean usaFiltroSolar,
        String frequenciaFiltroSolar,

        Boolean tabagismo,
        Integer quantidadeCigarrosDia,

        Boolean ingereBebidaAlcoolica,
        String frequenciaBebidaAlcoolica,

        String funcionamentoIntestinal,

        Boolean qualidadeSono,
        Integer horasSono,

        Integer ingestaoAguaCoposDia,

        String qualidadeAlimentacao,
        String alimentosPreferencia,

        Boolean praticaAtividadeFisica,
        String tipoAtividadeFisica,
        String frequenciaAtividadeFisica,

        Boolean usaAnticoncepcional,
        String anticonsepcionalDescricao,

        String dataPrimeiroDiaUltimaMenstruacao,

        Boolean gestante,
        Boolean gestacoes,
        Integer quantidadeGestacoes,
        String tempoGestacao,

        String anotacoes
) {

    public static HabitosDiariosResponse aPartirDe(HabitosDiarios habitosDiarios) {
        return new HabitosDiariosResponse(
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

