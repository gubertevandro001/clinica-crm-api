package com.gpa.clinica.crm.domain.repository;

import com.gpa.clinica.crm.domain.entity.Atendimento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AtendimentoRepository extends JpaRepository<Atendimento, String> {

    Optional<Atendimento> findByIdAndUsuarioId(String id, String usuarioId);

    Page<Atendimento> findAllByUsuarioId(String usuarioId, Pageable pageable);
}
