package com.warleydev.apimedic.repositories;

import com.warleydev.apimedic.entities.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Page<Paciente> findAllByAtivoTrue(PageRequest pageRequest);

    @Query("""
            select p.ativo
            from Paciente p
            where
            m.id = :id
            """)
    Boolean findAtivoById(Long id);
}
