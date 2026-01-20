package com.gpa.clinica.crm.api.model.response;

import com.gpa.clinica.crm.domain.entity.Atendimento;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record AtendimentoResponse(
        String id,
        String codigo,
        LocalDate dataAtendimento,
        PacienteResumoResponse paciente,
        List<ProcedimentoAtendimentoResponse> procedimentos,
        BigDecimal valor
) {

    public static AtendimentoResponse aPartirDe(Atendimento atendimento) {
        return new AtendimentoResponse(
                atendimento.getId(),
                atendimento.getCodigo(),
                atendimento.getDataAtendimento(),
                PacienteResumoResponse.aPartirDe(atendimento.getPaciente()),
                atendimento.getProcedimentos().stream().map(ProcedimentoAtendimentoResponse::aPartirDe).toList(),
                atendimento.getValor()
        );
    }
}
