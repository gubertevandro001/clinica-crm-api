package com.gpa.clinica.crm.api.model.request;

import java.math.BigDecimal;

public record CadastrarProcedimentoRequest(
        String nome,
        String descricao,
        String tipo,
        BigDecimal valor
) {
}
