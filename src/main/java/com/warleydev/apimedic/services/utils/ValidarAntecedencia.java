package com.warleydev.apimedic.services.utils;

import com.warleydev.apimedic.dto.consultas.DadosAgendamentoConsulta;
import com.warleydev.apimedic.services.exceptions.DateException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidarAntecedencia implements ValidarAgendamentoConsulta{
    public void validar(DadosAgendamentoConsulta dto){
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dto.data()).toMinutes();
        if (diferencaEmMinutos < 30){
            throw new DateException("A consulta deve ser marcada com antecedência mínima de 30 minutos");
        }
    }
}
