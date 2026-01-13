package com.gpa.clinica.crm.api.model.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CadastrarPacienteRequest(

        @NotBlank
        String nome,

        @NotBlank
        String cpf,

        @NotNull
        Integer idade,

        @NotNull
        LocalDate dataNascimento,

        @NotBlank
        String profissao,

        @NotBlank
        String estadoCivil,

        @Valid
        @NotNull
        EnderecoRequest endereco,

        @Valid
        @NotNull
        ContatoRequest contato,

        @Valid
        @NotNull
        AnamneseRequest anamnese
) {}
