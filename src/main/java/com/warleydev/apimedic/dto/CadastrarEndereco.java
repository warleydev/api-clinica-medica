package com.warleydev.apimedic.dto;

import com.warleydev.apimedic.entities.Endereco;

public record CadastrarEndereco(String logradouro, String bairro, String cep, String cidade, String uf, String complemento, String numero) {
    public CadastrarEndereco(Endereco endereco) {
        logradouro = endereco.getLogradouro();
        bairro = endereco.getBairro();
        cep = endereco.getCep();
        numero = endereco.getNumero();
        complemento = endereco.getComplemento();
        cidade = endereco.getCidade();
        uf = endereco.getUf();
    }
}
