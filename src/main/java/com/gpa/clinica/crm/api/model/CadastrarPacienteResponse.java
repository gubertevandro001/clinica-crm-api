package com.gpa.clinica.crm.api.model;

import java.time.LocalDateTime;

public record CadastrarPacienteResponse(
        String id,
        String nome,
        String cpf,
        Integer idade,
        LocalDateTime dataNascimento,
        String profissao,
        String estadoCivil,
        EnderecoModel endereco,
        ContatoModel contato,
        AnamneseModel anamnese
) {}
