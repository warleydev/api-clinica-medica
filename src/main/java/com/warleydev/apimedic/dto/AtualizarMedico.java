package com.warleydev.apimedic.dto;

import com.warleydev.apimedic.entities.Medico;

public record AtualizarMedico(String nome, String telefone, CadastrarEndereco endereco) {

    public AtualizarMedico(Medico entidade){
        this(entidade.getNome(), entidade.getTelefone(), new CadastrarEndereco(entidade.getEndereco()));
    }

}
