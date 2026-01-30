package com.gpa.clinica.crm.domain.valueobject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

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

    protected HistoricoClinico() {
    }

    public HistoricoClinico(Boolean tratamentoMedicoAtual, String medicamentosEmUso, Boolean antecedentesAlergicos,
                            String antecedentesAlergicosDescricao, Boolean portadorDeMarcapasso,
                            Boolean alteracoesCardiacas, String alteracoesDescricao, Boolean hipertensaoArterial,
                            Boolean disturbioCirculatorio, String disturbioCirculatorioDescricao,
                            Boolean disturbioRenal, String disturbioRenalDescricao, Boolean disturbioHormonal,
                            String disturbioHormonalDescricao, Boolean disturbioGastroIntestinal,
                            String disturbioGastroIntestinalDescricao, Boolean epilepsiaConvulsoes,
                            String epilepsiaConvulsoesDescricao, Boolean alteracoesPsicologicas,
                            String alteracoesPsicologicasDescricao, Boolean extresse, String extresseDescricao,
                            Boolean antecedentesOncologicos, String antecedentesOncologicosDescricao,
                            Boolean diabetes, String tipoDiabetes, Boolean possuiDoenca, String doencaDescricao) {
        this.tratamentoMedicoAtual = tratamentoMedicoAtual;
        this.medicamentosEmUso = medicamentosEmUso;
        this.antecedentesAlergicos = antecedentesAlergicos;
        this.antecedentesAlergicosDescricao = antecedentesAlergicosDescricao;
        this.portadorDeMarcapasso = portadorDeMarcapasso;
        this.alteracoesCardiacas = alteracoesCardiacas;
        this.alteracoesDescricao = alteracoesDescricao;
        this.hipertensaoArterial = hipertensaoArterial;
        this.disturbioCirculatorio = disturbioCirculatorio;
        this.disturbioCirculatorioDescricao = disturbioCirculatorioDescricao;
        this.disturbioRenal = disturbioRenal;
        this.disturbioRenalDescricao = disturbioRenalDescricao;
        this.disturbioHormonal = disturbioHormonal;
        this.disturbioHormonalDescricao = disturbioHormonalDescricao;
        this.disturbioGastroIntestinal = disturbioGastroIntestinal;
        this.disturbioGastroIntestinalDescricao = disturbioGastroIntestinalDescricao;
        this.epilepsiaConvulsoes = epilepsiaConvulsoes;
        this.epilepsiaConvulsoesDescricao = epilepsiaConvulsoesDescricao;
        this.alteracoesPsicologicas = alteracoesPsicologicas;
        this.alteracoesPsicologicasDescricao = alteracoesPsicologicasDescricao;
        this.extresse = extresse;
        this.extresseDescricao = extresseDescricao;
        this.antecedentesOncologicos = antecedentesOncologicos;
        this.antecedentesOncologicosDescricao = antecedentesOncologicosDescricao;
        this.diabetes = diabetes;
        this.tipoDiabetes = tipoDiabetes;
        this.possuiDoenca = possuiDoenca;
        this.doencaDescricao = doencaDescricao;
    }

    public Boolean getTratamentoMedicoAtual() {
        return tratamentoMedicoAtual;
    }

    public void setTratamentoMedicoAtual(Boolean tratamentoMedicoAtual) {
        this.tratamentoMedicoAtual = tratamentoMedicoAtual;
    }

    public String getMedicamentosEmUso() {
        return medicamentosEmUso;
    }

    public void setMedicamentosEmUso(String medicamentosEmUso) {
        this.medicamentosEmUso = medicamentosEmUso;
    }

    public Boolean getAntecedentesAlergicos() {
        return antecedentesAlergicos;
    }

    public void setAntecedentesAlergicos(Boolean antecedentesAlergicos) {
        this.antecedentesAlergicos = antecedentesAlergicos;
    }

    public String getAntecedentesAlergicosDescricao() {
        return antecedentesAlergicosDescricao;
    }

    public void setAntecedentesAlergicosDescricao(String antecedentesAlergicosDescricao) {
        this.antecedentesAlergicosDescricao = antecedentesAlergicosDescricao;
    }

    public Boolean getPortadorDeMarcapasso() {
        return portadorDeMarcapasso;
    }

    public void setPortadorDeMarcapasso(Boolean portadorDeMarcapasso) {
        this.portadorDeMarcapasso = portadorDeMarcapasso;
    }

    public Boolean getAlteracoesCardiacas() {
        return alteracoesCardiacas;
    }

    public void setAlteracoesCardiacas(Boolean alteracoesCardiacas) {
        this.alteracoesCardiacas = alteracoesCardiacas;
    }

    public String getAlteracoesDescricao() {
        return alteracoesDescricao;
    }

    public void setAlteracoesDescricao(String alteracoesDescricao) {
        this.alteracoesDescricao = alteracoesDescricao;
    }

    public Boolean getHipertensaoArterial() {
        return hipertensaoArterial;
    }

    public void setHipertensaoArterial(Boolean hipertensaoArterial) {
        this.hipertensaoArterial = hipertensaoArterial;
    }

    public Boolean getDisturbioCirculatorio() {
        return disturbioCirculatorio;
    }

    public void setDisturbioCirculatorio(Boolean disturbioCirculatorio) {
        this.disturbioCirculatorio = disturbioCirculatorio;
    }

    public String getDisturbioCirculatorioDescricao() {
        return disturbioCirculatorioDescricao;
    }

    public void setDisturbioCirculatorioDescricao(String disturbioCirculatorioDescricao) {
        this.disturbioCirculatorioDescricao = disturbioCirculatorioDescricao;
    }

    public Boolean getDisturbioRenal() {
        return disturbioRenal;
    }

    public void setDisturbioRenal(Boolean disturbioRenal) {
        this.disturbioRenal = disturbioRenal;
    }

    public String getDisturbioRenalDescricao() {
        return disturbioRenalDescricao;
    }

    public void setDisturbioRenalDescricao(String disturbioRenalDescricao) {
        this.disturbioRenalDescricao = disturbioRenalDescricao;
    }

    public Boolean getDisturbioHormonal() {
        return disturbioHormonal;
    }

    public void setDisturbioHormonal(Boolean disturbioHormonal) {
        this.disturbioHormonal = disturbioHormonal;
    }

    public String getDisturbioHormonalDescricao() {
        return disturbioHormonalDescricao;
    }

    public void setDisturbioHormonalDescricao(String disturbioHormonalDescricao) {
        this.disturbioHormonalDescricao = disturbioHormonalDescricao;
    }

    public Boolean getDisturbioGastroIntestinal() {
        return disturbioGastroIntestinal;
    }

    public void setDisturbioGastroIntestinal(Boolean disturbioGastroIntestinal) {
        this.disturbioGastroIntestinal = disturbioGastroIntestinal;
    }

    public String getDisturbioGastroIntestinalDescricao() {
        return disturbioGastroIntestinalDescricao;
    }

    public void setDisturbioGastroIntestinalDescricao(String disturbioGastroIntestinalDescricao) {
        this.disturbioGastroIntestinalDescricao = disturbioGastroIntestinalDescricao;
    }

    public Boolean getEpilepsiaConvulsoes() {
        return epilepsiaConvulsoes;
    }

    public void setEpilepsiaConvulsoes(Boolean epilepsiaConvulsoes) {
        this.epilepsiaConvulsoes = epilepsiaConvulsoes;
    }

    public String getEpilepsiaConvulsoesDescricao() {
        return epilepsiaConvulsoesDescricao;
    }

    public void setEpilepsiaConvulsoesDescricao(String epilepsiaConvulsoesDescricao) {
        this.epilepsiaConvulsoesDescricao = epilepsiaConvulsoesDescricao;
    }

    public Boolean getAlteracoesPsicologicas() {
        return alteracoesPsicologicas;
    }

    public void setAlteracoesPsicologicas(Boolean alteracoesPsicologicas) {
        this.alteracoesPsicologicas = alteracoesPsicologicas;
    }

    public String getAlteracoesPsicologicasDescricao() {
        return alteracoesPsicologicasDescricao;
    }

    public void setAlteracoesPsicologicasDescricao(String alteracoesPsicologicasDescricao) {
        this.alteracoesPsicologicasDescricao = alteracoesPsicologicasDescricao;
    }

    public Boolean getExtresse() {
        return extresse;
    }

    public void setExtresse(Boolean extresse) {
        this.extresse = extresse;
    }

    public String getExtresseDescricao() {
        return extresseDescricao;
    }

    public void setExtresseDescricao(String extresseDescricao) {
        this.extresseDescricao = extresseDescricao;
    }

    public Boolean getAntecedentesOncologicos() {
        return antecedentesOncologicos;
    }

    public void setAntecedentesOncologicos(Boolean antecedentesOncologicos) {
        this.antecedentesOncologicos = antecedentesOncologicos;
    }

    public String getAntecedentesOncologicosDescricao() {
        return antecedentesOncologicosDescricao;
    }

    public void setAntecedentesOncologicosDescricao(String antecedentesOncologicosDescricao) {
        this.antecedentesOncologicosDescricao = antecedentesOncologicosDescricao;
    }

    public Boolean getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(Boolean diabetes) {
        this.diabetes = diabetes;
    }

    public String getTipoDiabetes() {
        return tipoDiabetes;
    }

    public void setTipoDiabetes(String tipoDiabetes) {
        this.tipoDiabetes = tipoDiabetes;
    }

    public Boolean getPossuiDoenca() {
        return possuiDoenca;
    }

    public void setPossuiDoenca(Boolean possuiDoenca) {
        this.possuiDoenca = possuiDoenca;
    }

    public String getDoencaDescricao() {
        return doencaDescricao;
    }

    public void setDoencaDescricao(String doencaDescricao) {
        this.doencaDescricao = doencaDescricao;
    }
}
