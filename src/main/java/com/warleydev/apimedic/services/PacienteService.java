package com.warleydev.apimedic.services;

import com.warleydev.apimedic.dto.BuscarPacientes;
import com.warleydev.apimedic.dto.CadastroPaciente;
import com.warleydev.apimedic.entities.Paciente;
import com.warleydev.apimedic.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    @Transactional
    public CadastroPaciente salvar(Paciente entidade){
        entidade = repository.save(entidade);
        return new CadastroPaciente(entidade);
    }

    @Transactional(readOnly = true)
    public Page<BuscarPacientes> buscandoTodosPacientes(PageRequest pageRequest){
        return repository.findAll(pageRequest).map(x -> new BuscarPacientes(x));
    }

}
