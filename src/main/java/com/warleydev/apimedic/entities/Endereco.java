package com.warleydev.apimedic.entities;

import com.warleydev.apimedic.dto.CadastrarEndereco;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(CadastrarEndereco endereco) {
        logradouro = endereco.logradouro();
        bairro = endereco.bairro();
        cep = endereco.cep();
        numero = endereco.numero();
        complemento = endereco.complemento();
        cidade = endereco.cidade();
        uf = endereco.uf();
    }
}
