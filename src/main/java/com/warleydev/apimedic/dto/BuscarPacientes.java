package com.warleydev.apimedic.dto;

import com.warleydev.apimedic.entities.Paciente;

public record BuscarPacientes(Long id, String nome, String email, String cpf) {

    public BuscarPacientes(Paciente entidade){
        this(entidade.getId(), entidade.getNome(), entidade.getEmail(), entidade.getCpf());
    }

}
