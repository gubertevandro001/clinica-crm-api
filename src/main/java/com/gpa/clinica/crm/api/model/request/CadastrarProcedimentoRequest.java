package com.gpa.clinica.crm.api.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CadastrarProcedimentoRequest(

        @NotBlank
        String nome,

        @NotBlank
        String descricao,

        @NotBlank
        String tipo,

        @NotNull
        BigDecimal valor
) {}
