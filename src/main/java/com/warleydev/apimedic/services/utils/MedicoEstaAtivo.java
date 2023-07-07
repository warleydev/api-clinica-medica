package com.warleydev.apimedic.services.utils;

import com.warleydev.apimedic.repositories.MedicoRepository;
import com.warleydev.apimedic.services.exceptions.InactiveException;

public class MedicoEstaAtivo {

    private MedicoRepository repository;

    public void validar(Long idMedico){
        if (idMedico == null){
            return;
        }

        var medicoAtivo = repository.findAtivoById(idMedico);

        if (!medicoAtivo){
            throw new InactiveException("Este médico está inativo. Id: " + idMedico);
        }
    }

}
