package com.gpa.clinica.crm.api.model.response;

import com.gpa.clinica.crm.domain.entity.Atendimento;

import java.math.BigDecimal;
import java.time.LocalDate;

public record AtendimentoResumoResponse(
        String id,
        String codigo,
        String nomePaciente,
        LocalDate dataAtendimento,
        BigDecimal valor
) {

    public static AtendimentoResumoResponse aPartirDe(Atendimento atendimento) {
        return new AtendimentoResumoResponse(
                atendimento.getId(),
                atendimento.getCodigo(),
                atendimento.getPaciente().getNome(),
                atendimento.getDataAtendimento(),
                atendimento.getValor()
        );
    }
}
