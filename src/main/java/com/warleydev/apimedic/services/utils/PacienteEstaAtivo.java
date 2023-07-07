package com.warleydev.apimedic.services.utils;

import com.warleydev.apimedic.repositories.PacienteRepository;
import com.warleydev.apimedic.services.exceptions.InactiveException;

public class PacienteEstaAtivo {

    private PacienteRepository repository;

    public void validar(Long idPaciente){
        if (idPaciente == null){
            return;
        }

        var pacienteAtivo = repository.findAtivoById(idPaciente);

        if (!pacienteAtivo){
            throw new InactiveException("Este médico está inativo. Id: " + idPaciente);
        }
    }

}
