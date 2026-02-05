package com.gpa.clinica.crm.api.model.response;

import com.gpa.clinica.crm.domain.entity.ProcedimentoAtendimento;

import java.math.BigDecimal;

public record ProcedimentoAtendimentoResponse(
        String id,
        String procedimentoId,
        String nome,
        BigDecimal valor
) {

    public static ProcedimentoAtendimentoResponse aPartirDe(ProcedimentoAtendimento procedimento) {
        return  new ProcedimentoAtendimentoResponse(
                procedimento.getId(),
                procedimento.getProcedimento().getId(),
                procedimento.getProcedimento().getNome(),
                procedimento.getProcedimento().getValor()
        );
    }
}
