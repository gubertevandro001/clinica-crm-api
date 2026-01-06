package com.gpa.clinica.crm.domain.repository;

import com.gpa.clinica.crm.domain.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, String> {

}
