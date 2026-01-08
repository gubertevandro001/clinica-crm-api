package com.gpa.clinica.crm.api.model;

import java.time.LocalDateTime;

public record CadastrarPacienteRequest(
        String nome,
        String cpf,
        Integer idade,
        LocalDateTime dataNascimento,
        String profissao,
        String estadoCivil,
        EnderecoModel endereco,
        DadosContatoModel contato,
        AnamneseModel anamnese
) {}
