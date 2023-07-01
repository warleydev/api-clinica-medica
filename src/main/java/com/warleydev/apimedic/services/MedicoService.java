package com.warleydev.apimedic.services;

import com.warleydev.apimedic.dto.CadastroMedicos;
import com.warleydev.apimedic.entities.Medico;
import com.warleydev.apimedic.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class MedicoService {

    @Autowired
    MedicoRepository repository;

    public CadastroMedicos save(Medico entidade){
        entidade = repository.save(entidade);
        return new CadastroMedicos(entidade);
    }

}
