package com.gpa.clinica.crm.api.model;

import java.time.LocalDate;

public record AtualizarPacienteRequest(
        String nome,
        Integer idade,
        LocalDate dataNascimento,
        String profissao,
        String estadoCivil,
        EnderecoModel endereco,
        ContatoModel contato,
        AnamneseHabitosDiariosModel anamnese
) {}