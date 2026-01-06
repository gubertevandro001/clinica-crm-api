package com.gpa.clinica.crm.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class HistoricoClinico {

    @Column(name = "tratamento_medico_atual")
    private Boolean tratamentoMedicoAtual;

    @Column(name = "medicamentos_uso")
    private String medicamentosEmUso;

    @Column(name = "antecedentes_alergicos")
    private Boolean antecedentesAlergicos;

    @Column(name = "antecedentes_alergicos_descricao")
    private String antecedentesAlergicosDescricao;

    @Column(name = "portador_marcapasso")
    private Boolean portadorDeMarcapasso;

    @Column(name = "alteracoes_cardiacas")
    private Boolean alteracoesCardiacas;

    @Column(name = "alteracoes_descricao")
    private String alteracoesDescricao;

    @Column(name = "hipertensao_arterial")
    private Boolean hipertensaoArterial;

    @Column(name = "disturbio_circulatorio")
    private Boolean disturbioCirculatorio;

    @Column(name = "disturbio_circulario_descricao")
    private String disturbioCirculatorioDescricao;

    @Column(name = "disurbio_renal")
    private Boolean disturbioRenal;

    @Column(name = "disurbio_renal_descricao")
    private String disturbioRenalDescricao;

    @Column(name = "disurbio_hormonal")
    private Boolean disturbioHormonal;

    @Column(name = "disurbio_hormonal_descricao")
    private String disturbioHormonalDescricao;

    @Column(name = "disturbio_gastro_intestinal")
    private Boolean disturbioGastroIntestinal;

    @Column(name = "disturbio_gastro_descricao")
    private String disturbioGastroIntestinalDescricao;

    @Column(name = "epilepsia_convulsoes")
    private Boolean epilepsiaConvulsoes;

    @Column(name = "epilepsia_convulsoes_descricao")
    private String epilepsiaConvulsoesDescricao;

    @Column(name = "alteracoes_psicologicas")
    private Boolean alteracoesPsicologicas;

    @Column(name = "alteracoes_psicologicas_descricao")
    private String alteracoesPsicologicasDescricao;

    @Column(name = "extresse")
    private Boolean extresse;

    @Column(name = "extresse_descricao")
    private String extresseDescricao;

    @Column(name = "antecedentes_oncologicos")
    private Boolean antecedentesOncologicos;

    @Column(name = "antecedentes_oncologicos_descricao")
    private String antecedentesOncologicosDescricao;

    @Column(name = "diabetes")
    private Boolean diabetes;

    @Column(name = "tipo_diabetes")
    private String tipoDiabetes;

    @Column(name = "possui_doenca")
    private Boolean possuiDoenca;

    @Column(name = "doenca_descricao")
    private String doencaDescricao;
}
