package com.warleydev.apimedic.services.utils;

import com.warleydev.apimedic.dto.consultas.DadosAgendamentoConsulta;
import com.warleydev.apimedic.repositories.ConsultaRepository;
import com.warleydev.apimedic.services.exceptions.DateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarConsultaMesmoDia implements ValidarAgendamentoConsulta{

    @Autowired
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
