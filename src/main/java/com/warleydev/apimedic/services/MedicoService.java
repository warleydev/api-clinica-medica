package com.warleydev.apimedic.services;

import com.warleydev.apimedic.dto.BuscarMedicos;
import com.warleydev.apimedic.dto.CadastroMedicos;
import com.warleydev.apimedic.entities.Medico;
import com.warleydev.apimedic.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;

@Service
public class MedicoService {

    @Autowired
    MedicoRepository repository;


    @Transactional
    public CadastroMedicos save(Medico entidade){
        entidade = repository.save(entidade);
        return new CadastroMedicos(entidade);
    }

    @Transactional(readOnly = true)
    public Page<BuscarMedicos> searchAll(PageRequest pageRequest){
        return repository.findAll(pageRequest).map(x -> new BuscarMedicos(x));
    }

}
