package com.gpa.clinica.crm.domain.valueobject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

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

    public HabitosDiarios(Boolean tratamentoEsteticoAnterior, String tratamentoEsteticoDescricao,
                          Boolean usaLentesDeContato, Boolean utilizaComesticos, String cosmeticosDescricao,
                          Boolean exposicaoSolar, Boolean usaFiltroSolar, String frequenciaFiltroSolar,
                          Boolean tabagismo, Integer quantidadeCigarrosDia, Boolean ingereBebidaAlcoolica,
                          String frequenciaBebidaAlcoolica, String funcionamentoIntestinal, Boolean qualidadeSono,
                          Integer horasSono, Integer ingestaoAguaCoposDia, String qualidadeAlimentacao,
                          String alimentosPreferencia, Boolean praticaAtividadeFisica, String tipoAtividadeFisica,
                          String frequenciaAtividadeFisica, Boolean usaAnticoncepcional,
                          String anticonsepcionalDescricao, String dataPrimeiroDiaUltimaMenstruacao,
                          Boolean gestante, Boolean gestacoes, Integer quantidadeGestacoes,
                          String tempoGestacao, String anotacoes) {
        this.tratamentoEsteticoAnterior = tratamentoEsteticoAnterior;
        this.tratamentoEsteticoDescricao = tratamentoEsteticoDescricao;
        this.usaLentesDeContato = usaLentesDeContato;
        this.utilizaComesticos = utilizaComesticos;
        this.cosmeticosDescricao = cosmeticosDescricao;
        this.exposicaoSolar = exposicaoSolar;
        this.usaFiltroSolar = usaFiltroSolar;
        this.frequenciaFiltroSolar = frequenciaFiltroSolar;
        this.tabagismo = tabagismo;
        this.quantidadeCigarrosDia = quantidadeCigarrosDia;
        this.ingereBebidaAlcoolica = ingereBebidaAlcoolica;
        this.frequenciaBebidaAlcoolica = frequenciaBebidaAlcoolica;
        this.funcionamentoIntestinal = funcionamentoIntestinal;
        this.qualidadeSono = qualidadeSono;
        this.horasSono = horasSono;
        this.ingestaoAguaCoposDia = ingestaoAguaCoposDia;
        this.qualidadeAlimentacao = qualidadeAlimentacao;
        this.alimentosPreferencia = alimentosPreferencia;
        this.praticaAtividadeFisica = praticaAtividadeFisica;
        this.tipoAtividadeFisica = tipoAtividadeFisica;
        this.frequenciaAtividadeFisica = frequenciaAtividadeFisica;
        this.usaAnticoncepcional = usaAnticoncepcional;
        this.anticonsepcionalDescricao = anticonsepcionalDescricao;
        this.dataPrimeiroDiaUltimaMenstruacao = dataPrimeiroDiaUltimaMenstruacao;
        this.gestante = gestante;
        this.gestacoes = gestacoes;
        this.quantidadeGestacoes = quantidadeGestacoes;
        this.tempoGestacao = tempoGestacao;
        this.anotacoes = anotacoes;
    }

    public Boolean getTratamentoEsteticoAnterior() {
        return tratamentoEsteticoAnterior;
    }

    public void setTratamentoEsteticoAnterior(Boolean tratamentoEsteticoAnterior) {
        this.tratamentoEsteticoAnterior = tratamentoEsteticoAnterior;
    }

    public String getTratamentoEsteticoDescricao() {
        return tratamentoEsteticoDescricao;
    }

    public void setTratamentoEsteticoDescricao(String tratamentoEsteticoDescricao) {
        this.tratamentoEsteticoDescricao = tratamentoEsteticoDescricao;
    }

    public Boolean getUsaLentesDeContato() {
        return usaLentesDeContato;
    }

    public void setUsaLentesDeContato(Boolean usaLentesDeContato) {
        this.usaLentesDeContato = usaLentesDeContato;
    }

    public Boolean getUtilizaComesticos() {
        return utilizaComesticos;
    }

    public void setUtilizaComesticos(Boolean utilizaComesticos) {
        this.utilizaComesticos = utilizaComesticos;
    }

    public String getCosmeticosDescricao() {
        return cosmeticosDescricao;
    }

    public void setCosmeticosDescricao(String cosmeticosDescricao) {
        this.cosmeticosDescricao = cosmeticosDescricao;
    }

    public Boolean getExposicaoSolar() {
        return exposicaoSolar;
    }

    public void setExposicaoSolar(Boolean exposicaoSolar) {
        this.exposicaoSolar = exposicaoSolar;
    }

    public Boolean getUsaFiltroSolar() {
        return usaFiltroSolar;
    }

    public void setUsaFiltroSolar(Boolean usaFiltroSolar) {
        this.usaFiltroSolar = usaFiltroSolar;
    }

    public String getFrequenciaFiltroSolar() {
        return frequenciaFiltroSolar;
    }

    public void setFrequenciaFiltroSolar(String frequenciaFiltroSolar) {
        this.frequenciaFiltroSolar = frequenciaFiltroSolar;
    }

    public Boolean getTabagismo() {
        return tabagismo;
    }

    public void setTabagismo(Boolean tabagismo) {
        this.tabagismo = tabagismo;
    }

    public Integer getQuantidadeCigarrosDia() {
        return quantidadeCigarrosDia;
    }

    public void setQuantidadeCigarrosDia(Integer quantidadeCigarrosDia) {
        this.quantidadeCigarrosDia = quantidadeCigarrosDia;
    }

    public Boolean getIngereBebidaAlcoolica() {
        return ingereBebidaAlcoolica;
    }

    public void setIngereBebidaAlcoolica(Boolean ingereBebidaAlcoolica) {
        this.ingereBebidaAlcoolica = ingereBebidaAlcoolica;
    }

    public String getFrequenciaBebidaAlcoolica() {
        return frequenciaBebidaAlcoolica;
    }

    public void setFrequenciaBebidaAlcoolica(String frequenciaBebidaAlcoolica) {
        this.frequenciaBebidaAlcoolica = frequenciaBebidaAlcoolica;
    }

    public String getFuncionamentoIntestinal() {
        return funcionamentoIntestinal;
    }

    public void setFuncionamentoIntestinal(String funcionamentoIntestinal) {
        this.funcionamentoIntestinal = funcionamentoIntestinal;
    }

    public Boolean getQualidadeSono() {
        return qualidadeSono;
    }

    public void setQualidadeSono(Boolean qualidadeSono) {
        this.qualidadeSono = qualidadeSono;
    }

    public Integer getHorasSono() {
        return horasSono;
    }

    public void setHorasSono(Integer horasSono) {
        this.horasSono = horasSono;
    }

    public Integer getIngestaoAguaCoposDia() {
        return ingestaoAguaCoposDia;
    }

    public void setIngestaoAguaCoposDia(Integer ingestaoAguaCoposDia) {
        this.ingestaoAguaCoposDia = ingestaoAguaCoposDia;
    }

    public String getQualidadeAlimentacao() {
        return qualidadeAlimentacao;
    }

    public void setQualidadeAlimentacao(String qualidadeAlimentacao) {
        this.qualidadeAlimentacao = qualidadeAlimentacao;
    }

    public String getAlimentosPreferencia() {
        return alimentosPreferencia;
    }

    public void setAlimentosPreferencia(String alimentosPreferencia) {
        this.alimentosPreferencia = alimentosPreferencia;
    }

    public Boolean getPraticaAtividadeFisica() {
        return praticaAtividadeFisica;
    }

    public void setPraticaAtividadeFisica(Boolean praticaAtividadeFisica) {
        this.praticaAtividadeFisica = praticaAtividadeFisica;
    }

    public String getTipoAtividadeFisica() {
        return tipoAtividadeFisica;
    }

    public void setTipoAtividadeFisica(String tipoAtividadeFisica) {
        this.tipoAtividadeFisica = tipoAtividadeFisica;
    }

    public String getFrequenciaAtividadeFisica() {
        return frequenciaAtividadeFisica;
    }

    public void setFrequenciaAtividadeFisica(String frequenciaAtividadeFisica) {
        this.frequenciaAtividadeFisica = frequenciaAtividadeFisica;
    }

    public Boolean getUsaAnticoncepcional() {
        return usaAnticoncepcional;
    }

    public void setUsaAnticoncepcional(Boolean usaAnticoncepcional) {
        this.usaAnticoncepcional = usaAnticoncepcional;
    }

    public String getAnticonsepcionalDescricao() {
        return anticonsepcionalDescricao;
    }

    public void setAnticonsepcionalDescricao(String anticonsepcionalDescricao) {
        this.anticonsepcionalDescricao = anticonsepcionalDescricao;
    }

    public String getDataPrimeiroDiaUltimaMenstruacao() {
        return dataPrimeiroDiaUltimaMenstruacao;
    }

    public void setDataPrimeiroDiaUltimaMenstruacao(String dataPrimeiroDiaUltimaMenstruacao) {
        this.dataPrimeiroDiaUltimaMenstruacao = dataPrimeiroDiaUltimaMenstruacao;
    }

    public Boolean getGestante() {
        return gestante;
    }

    public void setGestante(Boolean gestante) {
        this.gestante = gestante;
    }

    public Boolean getGestacoes() {
        return gestacoes;
    }

    public void setGestacoes(Boolean gestacoes) {
        this.gestacoes = gestacoes;
    }

    public Integer getQuantidadeGestacoes() {
        return quantidadeGestacoes;
    }

    public void setQuantidadeGestacoes(Integer quantidadeGestacoes) {
        this.quantidadeGestacoes = quantidadeGestacoes;
    }

    public String getTempoGestacao() {
        return tempoGestacao;
    }

    public void setTempoGestacao(String tempoGestacao) {
        this.tempoGestacao = tempoGestacao;
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }
}
