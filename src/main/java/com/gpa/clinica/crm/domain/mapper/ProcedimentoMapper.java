package com.gpa.clinica.crm.domain.mapper;

import com.gpa.clinica.crm.api.model.request.CadastrarProcedimentoRequest;
import com.gpa.clinica.crm.domain.entity.Procedimento;
import com.gpa.clinica.crm.domain.valueobject.TipoProcedimeno;

public class ProcedimentoMapper {

    public static Procedimento criarProcedimento(CadastrarProcedimentoRequest request) {
        return Procedimento.novoProcedimento(
                request.nome(),
                request.descricao(),
                TipoProcedimeno.valueOf(request.tipo()),
                request.valor()
        );
    }
}
