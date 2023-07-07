package com.warleydev.apimedic.services.utils;

import com.warleydev.apimedic.dto.consultas.DadosAgendamentoConsulta;
import com.warleydev.apimedic.repositories.MedicoRepository;
import com.warleydev.apimedic.services.exceptions.InactiveException;

public class MedicoEstaAtivo {

    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dto){
        if (dto.idMedico() == null){
            return;
        }

        var medicoAtivo = repository.findAtivoById(dto.idMedico());

        if (!medicoAtivo){
            throw new InactiveException("Este médico está inativo. Id: " + dto.idMedico());
        }
    }

}
