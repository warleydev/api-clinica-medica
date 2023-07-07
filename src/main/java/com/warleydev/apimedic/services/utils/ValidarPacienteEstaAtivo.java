package com.warleydev.apimedic.services.utils;

import com.warleydev.apimedic.dto.consultas.DadosAgendamentoConsulta;
import com.warleydev.apimedic.repositories.PacienteRepository;
import com.warleydev.apimedic.services.exceptions.InactiveException;

public class PacienteEstaAtivo {

    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dto){
        if (dto.idPaciente() == null){
            return;
        }

        var pacienteAtivo = repository.findAtivoById(dto.idPaciente());

        if (!pacienteAtivo){
            throw new InactiveException("Este médico está inativo. Id: " + dto.idPaciente());
        }
    }

}
