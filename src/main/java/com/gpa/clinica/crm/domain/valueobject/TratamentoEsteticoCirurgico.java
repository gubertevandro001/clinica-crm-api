package com.gpa.clinica.crm.domain.valueobject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class TratamentoEsteticoCirurgico {

    @Column(name = "implante_dentario")
    private Boolean implanteDentario;

    @Column(name = "implante_dentario_descricao")
    private String implanteDentarioDescricao;

    @Column(name = "tratamento_estetico")
    private Boolean tratamentoEstetico;

    @Column(name = "tratamento_estetico_descricao")
    private String tratamentoEsteticoDescricao;

    @Column(name = "cirurgia_plastica")
    private Boolean cirurgiaPlastica;

    @Column(name = "cirurgia_plastica_descricao")
    private String cirurgiaPlasticaDescricao;

    @Column(name = "cirurgia_repadora")
    private Boolean cirurgiaRepadora;

    @Column(name = "cirurgia_reparadora_descricao")
    private String cirurgiaReparadoraDescricao;

    public TratamentoEsteticoCirurgico() {}

    public TratamentoEsteticoCirurgico(Boolean implanteDentario, String implanteDentarioDescricao,
                                       Boolean tratamentoEstetico, String tratamentoEsteticoDescricao,
                                       Boolean cirurgiaPlastica, String cirurgiaPlasticaDescricao,
                                       Boolean cirurgiaRepadora, String cirurgiaReparadoraDescricao) {
        this.implanteDentario = implanteDentario;
        this.implanteDentarioDescricao = implanteDentarioDescricao;
        this.tratamentoEstetico = tratamentoEstetico;
        this.tratamentoEsteticoDescricao = tratamentoEsteticoDescricao;
        this.cirurgiaPlastica = cirurgiaPlastica;
        this.cirurgiaPlasticaDescricao = cirurgiaPlasticaDescricao;
        this.cirurgiaRepadora = cirurgiaRepadora;
        this.cirurgiaReparadoraDescricao = cirurgiaReparadoraDescricao;
    }

    public Boolean getImplanteDentario() {
        return implanteDentario;
    }

    public String getImplanteDentarioDescricao() {
        return implanteDentarioDescricao;
    }

    public Boolean getTratamentoEstetico() {
        return tratamentoEstetico;
    }

    public String getTratamentoEsteticoDescricao() {
        return tratamentoEsteticoDescricao;
    }

    public Boolean getCirurgiaPlastica() {
        return cirurgiaPlastica;
    }

    public String getCirurgiaPlasticaDescricao() {
        return cirurgiaPlasticaDescricao;
    }

    public Boolean getCirurgiaRepadora() {
        return cirurgiaRepadora;
    }

    public String getCirurgiaReparadoraDescricao() {
        return cirurgiaReparadoraDescricao;
    }
}
