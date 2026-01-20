package com.gpa.clinica.crm.domain.repository;

import com.gpa.clinica.crm.domain.entity.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface AtendimentoRepository extends JpaRepository<Atendimento, String>, JpaSpecificationExecutor<Atendimento> {

    Optional<Atendimento> findByIdAndUsuarioId(String id, String usuarioId);

}
