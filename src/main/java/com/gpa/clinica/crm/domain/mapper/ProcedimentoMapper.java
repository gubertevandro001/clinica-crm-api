package com.gpa.clinica.crm.domain.mapper;

import com.gpa.clinica.crm.api.model.request.CadastrarProcedimentoRequest;
import com.gpa.clinica.crm.domain.entity.Procedimento;

public class ProcedimentoMapper {

    public static Procedimento criarProcedimento(CadastrarProcedimentoRequest request) {
        return Procedimento.novoProcedimento(
                request.nome(),
                request.descricao(),
                request.tipo(),
                request.valor()
        );
    }
}
