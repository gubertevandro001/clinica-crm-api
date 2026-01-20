package com.gpa.clinica.crm.api.model.response;

import com.gpa.clinica.crm.domain.entity.Procedimento;

import java.math.BigDecimal;

public record ProcedimentoResponse(
        String id,
        String nome,
        String descricao,
        String tipo,
        BigDecimal valor
) {

    public static ProcedimentoResponse aPartirDe(Procedimento procedimento) {
        return new ProcedimentoResponse(
                procedimento.getId(),
                procedimento.getNome(),
                procedimento.getDescricao(),
                procedimento.getTipo(),
                procedimento.getValor()
        );
    }
}
