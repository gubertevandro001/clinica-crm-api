package com.gpa.clinica.crm.domain.repository;

import com.gpa.clinica.crm.domain.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PacienteRepository extends JpaRepository<Paciente, String>, JpaSpecificationExecutor<Paciente> {


}
