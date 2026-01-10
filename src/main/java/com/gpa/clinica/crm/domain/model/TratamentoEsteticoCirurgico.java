package com.gpa.clinica.crm.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
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
}
