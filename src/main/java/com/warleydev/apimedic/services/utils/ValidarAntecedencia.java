package com.warleydev.apimedic.services.utils;

import com.warleydev.apimedic.services.exceptions.DateException;

import java.time.Duration;
import java.time.LocalDateTime;

public class ValidarAntecedencia {
    public void validar(LocalDateTime data){
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, data).toMinutes();
        if (diferencaEmMinutos < 30){
            throw new DateException("A consulta deve ser marcada com antecedência mínima de 30 minutos");
        }
    }
}
