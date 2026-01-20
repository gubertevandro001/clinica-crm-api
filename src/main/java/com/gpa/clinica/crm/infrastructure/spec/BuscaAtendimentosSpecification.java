package com.gpa.clinica.crm.infrastructure.spec;

import com.gpa.clinica.crm.domain.entity.Atendimento;
import jakarta.persistence.criteria.Path;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class BuscaAtendimentosSpecification {

    public static Specification<Atendimento> porUsuario(String usuarioId) {
        return (root, query, cb) -> {
            if (usuarioId == null) return null;
            return cb.equal(root.get("usuario").get("id"), usuarioId);
        };
    }

    public static Specification<Atendimento> porCpfPaciente(String cpf) {
        return (root, query, cb) -> {
            if (cpf == null || cpf.isBlank()) return null;

            return cb.equal(
                    root.get("paciente").get("cpf"),
                    cpf
            );
        };
    }

    public static Specification<Atendimento> porNomePaciente(String nome) {
        return (root, query, cb) -> {
            if (nome == null || nome.isBlank()) return null;

            return cb.like(
                    cb.lower(root.get("paciente").get("nome")),
                    "%" + nome.toLowerCase() + "%"
            );
        };
    }

    public static Specification<Atendimento> porPeriodo(LocalDate inicio, LocalDate fim) {
        return (root, query, cb) -> {
            if (inicio == null && fim == null) return null;

            Path<LocalDateTime> data = root.get("dataAtendimento");

            if (inicio != null && fim != null) {
                return cb.between(
                        data,
                        inicio.atStartOfDay(),
                        fim.atTime(LocalTime.MAX)
                );
            }

            if (inicio != null) {
                return cb.greaterThanOrEqualTo(
                        data,
                        inicio.atStartOfDay()
                );
            }

            return cb.lessThanOrEqualTo(
                    data,
                    fim.atTime(LocalTime.MAX)
            );
        };
    }

    public static Specification<Atendimento> buscarPor(String usuarioId, String nomePaciente, LocalDate inicio, LocalDate fim) {
        return Specification.where(porUsuario(usuarioId))
                .and(porNomePaciente(nomePaciente))
                .and(porPeriodo(inicio, fim));
    }
}
