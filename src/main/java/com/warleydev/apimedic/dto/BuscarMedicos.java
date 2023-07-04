package com.warleydev.apimedic.dto;

import com.warleydev.apimedic.entities.Medico;
import com.warleydev.apimedic.entities.enums.Especialidade;

public record BuscarMedicos(String nome, String email, String crm, Especialidade especialidade) {

    public BuscarMedicos(Medico entidade){

        this(entidade.getNome(), entidade.getEmail(), entidade.getCrm(), entidade.getEspecialidade());

    }

}
