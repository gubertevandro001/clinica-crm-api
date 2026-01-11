package com.gpa.clinica.crm.domain.repository;

import com.gpa.clinica.crm.domain.model.Paciente;
import com.gpa.clinica.crm.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    Optional<Usuario> findByLogin(String login);

    boolean existsByLogin(String login);

    boolean existsByEmail(String email);

    @Query("""
                select p
                from Usuario u
                join u.pacientes p
                where u.id = :usuarioId
                  and p.id = :pacienteId
            """)
    Optional<Paciente> buscarPaciente(
            String usuarioId,
            String pacienteId
    );

    @Query(""" 
            select p from Usuario u join u.pacientes p where u.id = :usuarioId
            """)
    List<Paciente> buscarPacientes(String usuarioId);
}
