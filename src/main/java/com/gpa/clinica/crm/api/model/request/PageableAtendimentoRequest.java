package com.gpa.clinica.crm.api.model.request;

import java.time.LocalDate;

public record PageableAtendimentoRequest(
        String nome,
        LocalDate dataInicio,
        LocalDate dataFim,
        int numeroDaPagina,
        int registrosPorPagina
) { }
