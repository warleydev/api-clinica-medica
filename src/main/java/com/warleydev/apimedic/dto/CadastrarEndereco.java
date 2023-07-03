package com.warleydev.apimedic.dto;

import com.warleydev.apimedic.entities.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CadastrarEndereco(

        @NotBlank(message = "Este campo é obrigatório")
        String logradouro,

        @NotBlank(message = "Este campo é obrigatório")
        String bairro,

        @NotBlank(message = "Este campo é obrigatório")
        @Pattern(regexp = "\\d{8}")
        String cep,

        @NotBlank(message = "Este campo é obrigatório")
        String cidade,

        @NotBlank(message = "Este campo é obrigatório")
        String uf,

        String complemento,
        String numero) {
    public CadastrarEndereco(Endereco endereco) {
        this(endereco.getLogradouro(), endereco.getBairro(), endereco.getCep(), endereco.getCidade(), endereco.getUf(), endereco.getComplemento(), endereco.getNumero());
    }
}
