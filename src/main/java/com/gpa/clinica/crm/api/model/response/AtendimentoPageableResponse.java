package com.gpa.clinica.crm.api.model.response;

import com.gpa.clinica.crm.domain.entity.Atendimento;
import org.springframework.data.domain.Page;

import java.util.List;

public record AtendimentoPageableResponse(
        List<AtendimentoResumoResponse> atendimentos,
        Long totalDeRegistros,
        Integer totalDePaginas,
        Integer paginaAtual,
        Integer registrosPorPagina
) {

    public static AtendimentoPageableResponse aPartirDe(Page<Atendimento> page) {
        List<AtendimentoResumoResponse> atendimentos = page.getContent()
                .stream()
                .map(AtendimentoResumoResponse::aPartirDe)
                .toList();

        return new AtendimentoPageableResponse(
                atendimentos,
                page.getTotalElements(),
                page.getTotalPages(),
                page.getNumber() + 1,
                page.getSize()
        );
    }
}
