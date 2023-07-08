package com.warleydev.apimedic.services.utils;

import com.warleydev.apimedic.dto.consultas.DadosAgendamentoConsulta;
import com.warleydev.apimedic.services.exceptions.DateException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidarHorarioFuncionamentoClinica implements ValidarAgendamentoConsulta{

    public void validar(DadosAgendamentoConsulta dto){

        var domingo = dto.data().getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDeAbrir = dto.data().getHour() < 7;
        var depoisDeFechar = dto.data().getHour() > 18;

        if (domingo || antesDeAbrir || depoisDeFechar){
            throw new DateException("Horário de funcionamento é de Segunda à Sábado das 07:00 às 19:00");
        }

    }

}
