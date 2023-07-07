package com.warleydev.apimedic.services.utils;

import com.warleydev.apimedic.dto.consultas.DadosAgendamentoConsulta;
import com.warleydev.apimedic.dto.consultas.DetalhesConsulta;
import com.warleydev.apimedic.repositories.ConsultaRepository;
import com.warleydev.apimedic.services.exceptions.DateException;

public class MedicoComConsultaNoHorario {

    private ConsultaRepository repository;
    public void validar(DadosAgendamentoConsulta dto){


        var possuiConsultaMesmaData = repository.existsByMedicoAndData(dto.idMedico(), dto.data());
        if (possuiConsultaMesmaData){
            throw new DateException("Médico já possui outra consultada para este horário.");
        }

    }

}
