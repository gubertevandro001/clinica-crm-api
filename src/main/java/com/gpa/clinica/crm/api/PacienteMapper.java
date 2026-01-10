package com.gpa.clinica.crm.api;

import com.gpa.clinica.crm.api.model.*;
import com.gpa.clinica.crm.domain.model.*;

public class PacienteMapper {

    public static Paciente criarPaciente(CadastrarPacienteRequest pacienteRequest) {
        return Paciente.novoPaciente(
                pacienteRequest.nome(),
                pacienteRequest.cpf(),
                pacienteRequest.idade(),
                pacienteRequest.dataNascimento(),
                pacienteRequest.profissao(),
                pacienteRequest.estadoCivil(),
                criarEndereco(pacienteRequest.endereco()),
                criarDadosContato(pacienteRequest.contato()),
                criarAnamnese(pacienteRequest.anamnese())
        );
    }

    private static Endereco criarEndereco(EnderecoModel enderecoModel) {
        return new Endereco(
                enderecoModel.cidade(),
                enderecoModel.estado(),
                enderecoModel.bairro(),
                enderecoModel.cep(),
                enderecoModel.logradouro(),
                enderecoModel.numero(),
                enderecoModel.complemento()
        );
    }

    private static Anamnese criarAnamnese(AnamneseModel anamneseModel) {
        return Anamnese.novaAnamnese(
                criarHabitosDiarios(anamneseModel.habitosDiarios()),
                criarHistoricoClinico(anamneseModel.historicoClinico()),
                criarTratamento(anamneseModel.tratamentoEsteticoCirurgico())
        );
    }

    private static HabitosDiarios criarHabitosDiarios(HabitosDiariosModel habitosDiariosModel) {
        return new HabitosDiarios(
                habitosDiariosModel.tratamentoEsteticoAnterior(),
                habitosDiariosModel.tratamentoEsteticoDescricao(),
                habitosDiariosModel.usaLentesDeContato(),
                habitosDiariosModel.utilizaComesticos(),
                habitosDiariosModel.cosmeticosDescricao(),
                habitosDiariosModel.exposicaoSolar(),
                habitosDiariosModel.usaFiltroSolar(),
                habitosDiariosModel.frequenciaFiltroSolar(),
                habitosDiariosModel.tabagismo(),
                habitosDiariosModel.quantidadeCigarrosDia(),
                habitosDiariosModel.ingereBebidaAlcoolica(),
                habitosDiariosModel.frequenciaBebidaAlcoolica(),
                habitosDiariosModel.funcionamentoIntestinal(),
                habitosDiariosModel.qualidadeSono(),
                habitosDiariosModel.horasSono(),
                habitosDiariosModel.ingestaoAguaCoposDia(),
                habitosDiariosModel.qualidadeAlimentacao(),
                habitosDiariosModel.alimentosPreferencia(),
                habitosDiariosModel.praticaAtividadeFisica(),
                habitosDiariosModel.tipoAtividadeFisica(),
                habitosDiariosModel.frequenciaAtividadeFisica(),
                habitosDiariosModel.usaAnticoncepcional(),
                habitosDiariosModel.anticonsepcionalDescricao(),
                habitosDiariosModel.dataPrimeiroDiaUltimaMenstruacao(),
                habitosDiariosModel.gestante(),
                habitosDiariosModel.gestacoes(),
                habitosDiariosModel.quantidadeGestacoes(),
                habitosDiariosModel.tempoGestacao(),
                habitosDiariosModel.anotacoes()
        );
    }

    private static HistoricoClinico criarHistoricoClinico(HistoricoClinicoModel historicoClinicoModel) {
        return new HistoricoClinico(
                historicoClinicoModel.tratamentoMedicoAtual(),
                historicoClinicoModel.medicamentosEmUso(),
                historicoClinicoModel.antecedentesAlergicos(),
                historicoClinicoModel.antecedentesAlergicosDescricao(),
                historicoClinicoModel.portadorDeMarcapasso(),
                historicoClinicoModel.alteracoesCardiacas(),
                historicoClinicoModel.alteracoesDescricao(),
                historicoClinicoModel.hipertensaoArterial(),
                historicoClinicoModel.disturbioCirculatorio(),
                historicoClinicoModel.disturbioCirculatorioDescricao(),
                historicoClinicoModel.disturbioRenal(),
                historicoClinicoModel.disturbioRenalDescricao(),
                historicoClinicoModel.disturbioHormonal(),
                historicoClinicoModel.disturbioHormonalDescricao(),
                historicoClinicoModel.disturbioGastroIntestinal(),
                historicoClinicoModel.disturbioGastroIntestinalDescricao(),
                historicoClinicoModel.epilepsiaConvulsoes(),
                historicoClinicoModel.epilepsiaConvulsoesDescricao(),
                historicoClinicoModel.alteracoesPsicologicas(),
                historicoClinicoModel.alteracoesPsicologicasDescricao(),
                historicoClinicoModel.extresse(),
                historicoClinicoModel.extresseDescricao(),
                historicoClinicoModel.antecedentesOncologicos(),
                historicoClinicoModel.antecedentesOncologicosDescricao(),
                historicoClinicoModel.diabetes(),
                historicoClinicoModel.tipoDiabetes(),
                historicoClinicoModel.possuiDoenca(),
                historicoClinicoModel.doencaDescricao()
        );
    }

    private static TratamentoEsteticoCirurgico criarTratamento(TratamentoEsteticoCirurgicoModel tratamento) {
        return new TratamentoEsteticoCirurgico(
                tratamento.implanteDentario(),
                tratamento.implanteDentarioDescricao(),
                tratamento.tratamentoEstetico(),
                tratamento.tratamentoEsteticoDescricao(),
                tratamento.cirurgiaPlastica(),
                tratamento.cirurgiaPlasticaDescricao(),
                tratamento.cirurgiaRepadora(),
                tratamento.cirurgiaReparadoraDescricao()
        );
    }

    private static DadosContato criarDadosContato(DadosContatoModel dadosContato) {
        return new DadosContato(
                dadosContato.telefone(),
                dadosContato.celular(),
                dadosContato.email()
        );
    }
}
