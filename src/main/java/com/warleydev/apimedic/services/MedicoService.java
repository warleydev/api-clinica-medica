package com.warleydev.apimedic.services;

import com.warleydev.apimedic.dto.CadastroMedicos;
import com.warleydev.apimedic.entities.Medico;
import com.warleydev.apimedic.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MedicoService {

    @Autowired
    MedicoRepository repository;


    @Transactional
    public CadastroMedicos save(Medico entidade){
        entidade = repository.save(entidade);
        return new CadastroMedicos(entidade);
    }

}
