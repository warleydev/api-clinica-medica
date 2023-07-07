package com.warleydev.apimedic.dto.consultas;

import java.time.LocalDateTime;

public record DetalhesConsulta(Long id, Long idMedico, Long idPaciente, LocalDateTime data) {
}
