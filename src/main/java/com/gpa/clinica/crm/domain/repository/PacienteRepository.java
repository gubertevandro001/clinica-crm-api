package com.gpa.clinica.crm.domain.repository;

import com.gpa.clinica.crm.domain.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, String> {

    @Query("""
        select p
        from Paciente p
        join p.usuarios u
        where p.id = :pacienteId
          and u.id = :usuarioId
    """)
    Optional<Paciente> buscarPaciente(String pacienteId, String usuarioId);
}
