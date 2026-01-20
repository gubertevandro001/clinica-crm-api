package com.gpa.clinica.crm.domain.repository;

import com.gpa.clinica.crm.domain.entity.Procedimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcedimentoRepository extends JpaRepository<Procedimento, String> {
}
