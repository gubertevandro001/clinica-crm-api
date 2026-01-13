package com.gpa.clinica.crm.api.model.response;

import com.gpa.clinica.crm.domain.entity.Paciente;

import java.time.LocalDate;

public record PacienteResponse(
        String id,
        String nome,
        String cpf,
        Integer idade,
        LocalDate dataNascimento,
        String profissao,
        String estadoCivil,
        EnderecoResponse endereco,
        ContatoResponse contato,
        AnamneseResponse anamnese
) {

    public static PacienteResponse aPartirDe(Paciente paciente) {
        return new PacienteResponse(
                paciente.getId(),
                paciente.getNome(),
                paciente.getCpf(),
                paciente.getIdade(),
                paciente.getDataNascimento(),
                paciente.getProfissao(),
                paciente.getEstadoCivil(),
                EnderecoResponse.aPartirDe(paciente.getEndereco()),
                ContatoResponse.aPartirDe(paciente.getContato()),
                AnamneseResponse.aPartirDe(paciente.getAnamnese())
        );
    }
}
