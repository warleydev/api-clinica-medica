package com.warleydev.apimedic.dto.pacientes;

import com.warleydev.apimedic.dto.endereco.CadastrarEndereco;
import com.warleydev.apimedic.entities.Paciente;

public record AtualizarPaciente(String nome, String telefone, CadastrarEndereco endereco) {

    public AtualizarPaciente(Paciente entidade){
        this(entidade.getNome(), entidade.getTelefone(), new CadastrarEndereco(entidade.getEndereco()));
    }

}
