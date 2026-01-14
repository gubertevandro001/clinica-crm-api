package com.gpa.clinica.crm.api.model.response;

import com.gpa.clinica.crm.domain.entity.Paciente;
import org.springframework.data.domain.Page;

import java.util.List;

public record PacientePageableResponse(
        List<PacienteResumoResponse> pacientes,
        Long totalDeRegistros,
        Integer totalDePaginas,
        Integer paginaAtual,
        Integer registrosPorPagina
) {

    public static PacientePageableResponse aPartirDe(Page<Paciente> page) {
        List<PacienteResumoResponse> pacientes = page.getContent()
                .stream()
                .map(PacienteResumoResponse::aPartirDe)
                .toList();

        return new PacientePageableResponse(
                pacientes,
                page.getTotalElements(),
                page.getTotalPages(),
                page.getNumber() + 1,
                page.getSize()
        );
    }
}
