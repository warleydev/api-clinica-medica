package com.warleydev.apimedic.repositories;

import com.warleydev.apimedic.entities.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
