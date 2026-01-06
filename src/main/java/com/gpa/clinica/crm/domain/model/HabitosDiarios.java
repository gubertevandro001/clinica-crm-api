package com.gpa.clinica.crm.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class HabitosDiarios {

    @Column(name = "tratamento_estetico_anterior")
    private Boolean tratamentoEsteticoAnterior;

    @Column(name = "tratamento_estetico_anterior_descricao")
    private String tratamentoEsteticoDescricao;

    @Column(name = "usa_lentes_contato")
    private Boolean usaLentesDeContato;

    @Column(name = "utiliza_cosmeticos")
    private Boolean utilizaComesticos;

    @Column(name = "cosmeticos_descricao")
    private String cosmeticosDescricao;

    @Column(name = "exposicao_solar")
    private Boolean exposicaoSolar;

    @Column(name = "usa_filtro_solar")
    private Boolean usaFiltroSolar;

    @Column(name = "frequencia_filtro_solar")
    private String frequenciaFiltroSolar;

    @Column(name = "tabagismo")
    private Boolean tabagismo;

    @Column(name = "quantidade_cigarros_dia")
    private Integer quantidadeCigarrosDia;

    @Column(name = "ingere_bebida_alcoolica")
    private Boolean ingereBebidaAlcoolica;

    @Column(name = "frequencia_bebida_alcoolica")
    private String frequenciaBebidaAlcoolica;

    @Column(name = "funcionamento_intestinal")
    private String funcionamentoIntestinal;

    @Column(name = "qualidade_sono")
    private Boolean qualidadeSono;

    @Column(name = "horos_sono")
    private Integer horasSono;

    @Column(name = "ingestao_agua_copos_dia")
    private Integer ingestaoAguaCoposDia;

    @Column(name = "qualidade_alimentacao")
    private String qualidadeAlimentacao;

    @Column(name = "alimentos_preferencia")
    private String alimentosPreferencia;

    @Column(name = "pratica_atividade_fisica")
    private Boolean praticaAtividadeFisica;

    @Column(name = "tipo_atividade_fisica")
    private String tipoAtividadeFisica;

    @Column(name = "frequencia_atividade_fisica")
    private String frequenciaAtividadeFisica;

    @Column(name = "usa_anticoncepcional")
    private Boolean usaAnticoncepcional;

    @Column(name = "anticoncepcional_descricao")
    private String anticonsepcionalDescricao;

    @Column(name = "data_primeiro_dia_ultima_menstruacao")
    private String dataPrimeiroDiaUltimaMenstruacao;

    @Column(name = "gestante")
    private Boolean gestante;

    @Column(name = "gestacoes")
    private Boolean gestacoes;

    @Column(name = "quantidade_gestacoes")
    private Integer quantidadeGestacoes;

    @Column(name = "tempo_gestacao")
    private String tempoGestacao;

    @Column(name = "anotacoes")
    private String anotacoes;
}
