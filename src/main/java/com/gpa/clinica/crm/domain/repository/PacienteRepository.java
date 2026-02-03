package com.gpa.clinica.crm.domain.repository;

import com.gpa.clinica.crm.domain.entity.Paciente;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, String>, JpaSpecificationExecutor<Paciente> {

    @EntityGraph(attributePaths = {"anamnese", "conversas", "analises"})
    Optional<Paciente> findById(String id);


}
