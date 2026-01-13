package com.gpa.clinica.crm.domain.mapper;

import com.gpa.clinica.crm.api.model.request.CadastrarPacienteRequest;
import com.gpa.clinica.crm.domain.entity.*;
import com.gpa.clinica.crm.domain.valueobject.HabitosDiarios;
import com.gpa.clinica.crm.domain.valueobject.HistoricoClinico;
import com.gpa.clinica.crm.domain.valueobject.TratamentoEsteticoCirurgico;

public class PacienteMapper {

    public static Paciente criarPaciente(CadastrarPacienteRequest cadastrarPacienteRequest) {
        return new Paciente(
                cadastrarPacienteRequest.nome(),
                cadastrarPacienteRequest.cpf(),
                cadastrarPacienteRequest.idade(),
                cadastrarPacienteRequest.dataNascimento(),
                cadastrarPacienteRequest.profissao(),
                cadastrarPacienteRequest.estadoCivil(),
                EnderecoMapper.criarEndereco(cadastrarPacienteRequest.endereco()),
                ContatoMapper.criarContato(cadastrarPacienteRequest.contato()),
                new Anamnese(
                        new HabitosDiarios(
                                cadastrarPacienteRequest.anamnese().habitosDiarios().tratamentoEsteticoAnterior(),
                                cadastrarPacienteRequest.anamnese().habitosDiarios().tratamentoEsteticoDescricao(),
                                cadastrarPacienteRequest.anamnese().habitosDiarios().usaLentesDeContato(),
                                cadastrarPacienteRequest.anamnese().habitosDiarios().utilizaComesticos(),
                                cadastrarPacienteRequest.anamnese().habitosDiarios().cosmeticosDescricao(),
                                cadastrarPacienteRequest.anamnese().habitosDiarios().exposicaoSolar(),
                                cadastrarPacienteRequest.anamnese().habitosDiarios().usaFiltroSolar(),
                                cadastrarPacienteRequest.anamnese().habitosDiarios().frequenciaFiltroSolar(),
                                cadastrarPacienteRequest.anamnese().habitosDiarios().tabagismo(),
                                cadastrarPacienteRequest.anamnese().habitosDiarios().quantidadeCigarrosDia(),
                                cadastrarPacienteRequest.anamnese().habitosDiarios().ingereBebidaAlcoolica(),
                                cadastrarPacienteRequest.anamnese().habitosDiarios().frequenciaBebidaAlcoolica(),
                                cadastrarPacienteRequest.anamnese().habitosDiarios().funcionamentoIntestinal(),
                                cadastrarPacienteRequest.anamnese().habitosDiarios().qualidadeSono(),
                                cadastrarPacienteRequest.anamnese().habitosDiarios().horasSono(),
                                cadastrarPacienteRequest.anamnese().habitosDiarios().ingestaoAguaCoposDia(),
                                cadastrarPacienteRequest.anamnese().habitosDiarios().qualidadeAlimentacao(),
                                cadastrarPacienteRequest.anamnese().habitosDiarios().alimentosPreferencia(),
                                cadastrarPacienteRequest.anamnese().habitosDiarios().praticaAtividadeFisica(),
                                cadastrarPacienteRequest.anamnese().habitosDiarios().tipoAtividadeFisica(),
                                cadastrarPacienteRequest.anamnese().habitosDiarios().frequenciaAtividadeFisica(),
                                cadastrarPacienteRequest.anamnese().habitosDiarios().usaAnticoncepcional(),
                                cadastrarPacienteRequest.anamnese().habitosDiarios().anticonsepcionalDescricao(),
                                cadastrarPacienteRequest.anamnese().habitosDiarios().dataPrimeiroDiaUltimaMenstruacao(),
                                cadastrarPacienteRequest.anamnese().habitosDiarios().gestante(),
                                cadastrarPacienteRequest.anamnese().habitosDiarios().gestacoes(),
                                cadastrarPacienteRequest.anamnese().habitosDiarios().quantidadeGestacoes(),
                                cadastrarPacienteRequest.anamnese().habitosDiarios().tempoGestacao(),
                                cadastrarPacienteRequest.anamnese().habitosDiarios().anotacoes()
                        ),
                        new HistoricoClinico(
                                cadastrarPacienteRequest.anamnese().historicoClinico().tratamentoMedicoAtual(),
                                cadastrarPacienteRequest.anamnese().historicoClinico().medicamentosEmUso(),
                                cadastrarPacienteRequest.anamnese().historicoClinico().antecedentesAlergicos(),
                                cadastrarPacienteRequest.anamnese().historicoClinico().antecedentesAlergicosDescricao(),
                                cadastrarPacienteRequest.anamnese().historicoClinico().portadorDeMarcapasso(),
                                cadastrarPacienteRequest.anamnese().historicoClinico().alteracoesCardiacas(),
                                cadastrarPacienteRequest.anamnese().historicoClinico().alteracoesDescricao(),
                                cadastrarPacienteRequest.anamnese().historicoClinico().hipertensaoArterial(),
                                cadastrarPacienteRequest.anamnese().historicoClinico().disturbioCirculatorio(),
                                cadastrarPacienteRequest.anamnese().historicoClinico().disturbioCirculatorioDescricao(),
                                cadastrarPacienteRequest.anamnese().historicoClinico().disturbioRenal(),
                                cadastrarPacienteRequest.anamnese().historicoClinico().disturbioRenalDescricao(),
                                cadastrarPacienteRequest.anamnese().historicoClinico().disturbioHormonal(),
                                cadastrarPacienteRequest.anamnese().historicoClinico().disturbioHormonalDescricao(),
                                cadastrarPacienteRequest.anamnese().historicoClinico().disturbioGastroIntestinal(),
                                cadastrarPacienteRequest.anamnese().historicoClinico().disturbioGastroIntestinalDescricao(),
                                cadastrarPacienteRequest.anamnese().historicoClinico().epilepsiaConvulsoes(),
                                cadastrarPacienteRequest.anamnese().historicoClinico().epilepsiaConvulsoesDescricao(),
                                cadastrarPacienteRequest.anamnese().historicoClinico().alteracoesPsicologicas(),
                                cadastrarPacienteRequest.anamnese().historicoClinico().alteracoesPsicologicasDescricao(),
                                cadastrarPacienteRequest.anamnese().historicoClinico().extresse(),
                                cadastrarPacienteRequest.anamnese().historicoClinico().extresseDescricao(),
                                cadastrarPacienteRequest.anamnese().historicoClinico().antecedentesOncologicos(),
                                cadastrarPacienteRequest.anamnese().historicoClinico().antecedentesOncologicosDescricao(),
                                cadastrarPacienteRequest.anamnese().historicoClinico().diabetes(),
                                cadastrarPacienteRequest.anamnese().historicoClinico().tipoDiabetes(),
                                cadastrarPacienteRequest.anamnese().historicoClinico().possuiDoenca(),
                                cadastrarPacienteRequest.anamnese().historicoClinico().doencaDescricao()
                        ),
                        new TratamentoEsteticoCirurgico(
                                cadastrarPacienteRequest.anamnese().tratamentoEsteticoCirurgico().implanteDentario(),
                                cadastrarPacienteRequest.anamnese().tratamentoEsteticoCirurgico().implanteDentarioDescricao(),
                                cadastrarPacienteRequest.anamnese().tratamentoEsteticoCirurgico().tratamentoEstetico(),
                                cadastrarPacienteRequest.anamnese().tratamentoEsteticoCirurgico().tratamentoEsteticoDescricao(),
                                cadastrarPacienteRequest.anamnese().tratamentoEsteticoCirurgico().cirurgiaPlastica(),
                                cadastrarPacienteRequest.anamnese().tratamentoEsteticoCirurgico().cirurgiaPlasticaDescricao(),
                                cadastrarPacienteRequest.anamnese().tratamentoEsteticoCirurgico().cirurgiaRepadora(),
                                cadastrarPacienteRequest.anamnese().tratamentoEsteticoCirurgico().cirurgiaReparadoraDescricao()
                        )
                )
        );
    }
}
