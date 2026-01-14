package com.gpa.clinica.crm.api.model.response;

import com.gpa.clinica.crm.domain.entity.Paciente;

import java.time.LocalDate;

public record PacienteResumoResponse(
        String id,
        String nome,
        String cpf,
        Integer idade,
        LocalDate dataNascimento,
        String profissao,
        String estadoCivil,
        EnderecoResponse endereco,
        ContatoResponse contato
) {

    public static PacienteResumoResponse aPartirDe(Paciente paciente) {
        return new PacienteResumoResponse(
                paciente.getId(),
                paciente.getNome(),
                paciente.getCpf(),
                paciente.getIdade(),
                paciente.getDataNascimento(),
                paciente.getProfissao(),
                paciente.getEstadoCivil(),
                EnderecoResponse.aPartirDe(paciente.getEndereco()),
                ContatoResponse.aPartirDe(paciente.getContato())
        );
    }
}
