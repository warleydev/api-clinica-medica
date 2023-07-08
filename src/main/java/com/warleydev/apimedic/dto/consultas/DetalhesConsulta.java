package com.warleydev.apimedic.dto.consultas;

import com.warleydev.apimedic.entities.Consulta;

import java.time.LocalDateTime;

public record DetalhesConsulta(Long id, Long idMedico, Long idPaciente, LocalDateTime data) {

    public DetalhesConsulta(Consulta consulta){
        this(consulta.getId(), consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getData());
    }

}
