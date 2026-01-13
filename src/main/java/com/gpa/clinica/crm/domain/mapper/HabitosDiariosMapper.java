package com.gpa.clinica.crm.domain.mapper;

import com.gpa.clinica.crm.api.model.request.HabitosDiariosRequest;
import com.gpa.clinica.crm.domain.valueobject.HabitosDiarios;

public class HabitosDiariosMapper {

    public static HabitosDiarios criarHabitosDiarios(HabitosDiariosRequest habitosDiariosRequest) {
        return new HabitosDiarios(
                habitosDiariosRequest.tratamentoEsteticoAnterior(),
                habitosDiariosRequest.tratamentoEsteticoDescricao(),
                habitosDiariosRequest.usaLentesDeContato(),
                habitosDiariosRequest.utilizaComesticos(),
                habitosDiariosRequest.cosmeticosDescricao(),
                habitosDiariosRequest.exposicaoSolar(),
                habitosDiariosRequest.usaFiltroSolar(),
                habitosDiariosRequest.frequenciaFiltroSolar(),
                habitosDiariosRequest.tabagismo(),
                habitosDiariosRequest.quantidadeCigarrosDia(),
                habitosDiariosRequest.ingereBebidaAlcoolica(),
                habitosDiariosRequest.frequenciaBebidaAlcoolica(),
                habitosDiariosRequest.funcionamentoIntestinal(),
                habitosDiariosRequest.qualidadeSono(),
                habitosDiariosRequest.horasSono(),
                habitosDiariosRequest.ingestaoAguaCoposDia(),
                habitosDiariosRequest.qualidadeAlimentacao(),
                habitosDiariosRequest.alimentosPreferencia(),
                habitosDiariosRequest.praticaAtividadeFisica(),
                habitosDiariosRequest.tipoAtividadeFisica(),
                habitosDiariosRequest.frequenciaAtividadeFisica(),
                habitosDiariosRequest.usaAnticoncepcional(),
                habitosDiariosRequest.anticonsepcionalDescricao(),
                habitosDiariosRequest.dataPrimeiroDiaUltimaMenstruacao(),
                habitosDiariosRequest.gestante(),
                habitosDiariosRequest.gestacoes(),
                habitosDiariosRequest.quantidadeGestacoes(),
                habitosDiariosRequest.tempoGestacao(),
                habitosDiariosRequest.anotacoes()
        );
    }
}
