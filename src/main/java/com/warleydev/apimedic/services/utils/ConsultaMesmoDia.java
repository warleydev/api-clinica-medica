package com.warleydev.apimedic.services.utils;

import com.warleydev.apimedic.dto.consultas.DadosAgendamentoConsulta;
import com.warleydev.apimedic.repositories.ConsultaRepository;
import com.warleydev.apimedic.services.exceptions.DateException;

public class ConsultaMesmoDia {

    ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dto){
        var primeiroHorario = dto.data().withHour(7);
        var ultimoHorario = dto.data().withHour(18);
        var pacientePossuiUmaConsultaNoDia = repository.existsByPacienteIdAndDataBetween(dto.idPaciente(), primeiroHorario, ultimoHorario);
        if (pacientePossuiUmaConsultaNoDia){
            throw new DateException("Paciente já possui consulta para este dia.");
        }
    }
}
