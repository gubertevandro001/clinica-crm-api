package com.gpa.clinica.crm.api.model.request;

public record PageableRequest(
        String filtro,
        int numeroDaPagina,
        int registrosPorPagina
) {
}
