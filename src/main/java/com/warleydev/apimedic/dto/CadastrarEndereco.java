package com.warleydev.apimedic.dto;

import com.warleydev.apimedic.entities.Endereco;

public record CadastrarEndereco(String logradouro, String bairro, String cep, String cidade, String uf, String complemento, String numero) {
    public CadastrarEndereco(Endereco endereco) {
        this(endereco.getLogradouro(), endereco.getBairro(), endereco.getCep(), endereco.getCidade(), endereco.getUf(), endereco.getComplemento(), endereco.getNumero());
    }
}
