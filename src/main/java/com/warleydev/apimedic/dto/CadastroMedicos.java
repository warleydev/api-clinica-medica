package com.warleydev.apimedic.dto;

import com.warleydev.apimedic.entities.Endereco;
import com.warleydev.apimedic.entities.Medico;
import com.warleydev.apimedic.entities.enums.Especialidade;

public record CadastroMedicos(String nome, String email, String crm, Especialidade especialidade, CadastrarEndereco endereco) {

    public CadastroMedicos(Medico entidade) {
        nome = entidade.getNome();
        email = entidade.getEmail();
        crm = entidade.getCrm();
        especialidade = entidade.getEspecialidade();
        endereco = new Endereco(new CadastrarEndereco(entidade.getEndereco()));
    }

}
