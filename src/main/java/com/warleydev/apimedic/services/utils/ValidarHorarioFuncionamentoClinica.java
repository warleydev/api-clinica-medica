package com.warleydev.apimedic.services.utils;

import com.warleydev.apimedic.dto.consultas.DadosAgendamentoConsulta;
import com.warleydev.apimedic.services.exceptions.DateException;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class ValidarHorarioFuncionamentoClinica {

    public void validar(LocalDateTime data){

        var domingo = data.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDeAbrir = data.getHour() < 7;
        var depoisDeFechar = data.getHour() > 18;

        if (domingo || antesDeAbrir || depoisDeFechar){
            throw new DateException("Horário de funcionamento é de Segunda à Sábado das 07:00 às 19:00");
        }

    }

}
