package com.warleydev.apimedic.repositories;

import com.warleydev.apimedic.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Long, Paciente> {
}
