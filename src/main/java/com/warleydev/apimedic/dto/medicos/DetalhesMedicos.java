package com.warleydev.apimedic.dto.medicos;

import com.warleydev.apimedic.entities.Endereco;
import com.warleydev.apimedic.entities.Medico;
import com.warleydev.apimedic.entities.enums.Especialidade;

public record DetalhesMedicos(Long id, String nome, String email, String telefone, String crm, Especialidade especialidade, Endereco endereco, Boolean ativo){

    public DetalhesMedicos(Medico entidade){
        this(entidade.getId(), entidade.getNome(), entidade.getEmail(), entidade.getTelefone(), entidade.getCrm(), entidade.getEspecialidade(), entidade.getEndereco(), entidade.getAtivo());
    }

}
