package com.warleydev.apimedic.dto;

import com.warleydev.apimedic.entities.Endereco;
import com.warleydev.apimedic.entities.Medico;
import com.warleydev.apimedic.entities.enums.Especialidade;

public record CadastroMedicos(String nome, String email, String crm, Especialidade especialidade, CadastrarEndereco endereco) {

    public CadastroMedicos(Medico entidade) {
        this(entidade.getNome(), entidade.getEmail(), entidade.getCrm(), entidade.getEspecialidade(), new CadastrarEndereco(entidade.getEndereco()));
    }

}
