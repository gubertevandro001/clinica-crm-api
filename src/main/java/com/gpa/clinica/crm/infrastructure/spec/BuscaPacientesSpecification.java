package com.gpa.clinica.crm.infrastructure.spec;

import com.gpa.clinica.crm.domain.entity.Paciente;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class BuscaPacientesSpecification {

    public static Specification<Paciente> buscarPor(String filtro) {
        return (root, query, cb) -> {

            if (!StringUtils.hasText(filtro)) {
                return cb.conjunction();
            }

            String f = "%" + filtro.toLowerCase() + "%";

            return cb.or(
                    cb.like(cb.lower(root.get("nome")), f),
                    cb.like(cb.lower(root.get("cpf")), f),
                    cb.like(cb.lower(root.get("email")), f),
                    cb.like(cb.lower(root.get("login")), f)
            );
        };
    }
}
