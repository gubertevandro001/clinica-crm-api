package com.gpa.clinica.crm.api.model;

public record HabitosDiariosModel(

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
}

