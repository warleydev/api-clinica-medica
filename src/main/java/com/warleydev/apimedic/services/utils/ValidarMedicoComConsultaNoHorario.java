package com.warleydev.apimedic.services.utils;

import com.warleydev.apimedic.dto.consultas.DadosAgendamentoConsulta;
import com.warleydev.apimedic.repositories.ConsultaRepository;
import com.warleydev.apimedic.services.exceptions.DateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarMedicoComConsultaNoHorario implements ValidarAgendamentoConsulta{

    @Autowired
    private ConsultaRepository repository;
    public void validar(DadosAgendamentoConsulta dto){


        var possuiConsultaMesmaData = repository.existsByMedicoIdAndData(dto.idMedico(), dto.data());
        if (possuiConsultaMesmaData){
            throw new DateException("Médico já possui outra consultada para este horário.");
        }

    }

}
