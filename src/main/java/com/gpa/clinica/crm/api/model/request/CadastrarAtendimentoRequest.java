package com.gpa.clinica.crm.api.model.request;

import java.util.List;

public record CadastrarAtendimentoRequest(
        String pacienteId,
        List<ProcedimentoIdRequest> procedimentos
) {
}
