package com.warleydev.apimedic.dto.medicos;

import com.warleydev.apimedic.dto.endereco.CadastrarEndereco;
import com.warleydev.apimedic.entities.Medico;

public record AtualizarMedico(String nome, String telefone, CadastrarEndereco endereco) {

    public AtualizarMedico(Medico entidade){
        this(entidade.getNome(), entidade.getTelefone(), new CadastrarEndereco(entidade.getEndereco()));
    }

}
