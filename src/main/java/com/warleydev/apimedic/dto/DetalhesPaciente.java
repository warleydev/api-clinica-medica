package com.warleydev.apimedic.dto;

import com.warleydev.apimedic.entities.Endereco;
import com.warleydev.apimedic.entities.Paciente;

public record DetalhesPaciente(Long id, String nome, String email, String telefone, String cpf, Endereco endereco) {

    public DetalhesPaciente(Paciente entidade){
        this(entidade.getId(), entidade.getNome(), entidade.getEmail(), entidade.getTelefone(), entidade.getCpf(), entidade.getEndereco());
    }

}
