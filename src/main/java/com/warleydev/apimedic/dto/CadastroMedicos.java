package com.warleydev.apimedic.dto;

import com.warleydev.apimedic.entities.Endereco;
import com.warleydev.apimedic.entities.Medico;
import com.warleydev.apimedic.entities.enums.Especialidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CadastroMedicos(

        @NotBlank(message = "Este campo não pode estar vazio.")
        String nome,

        @NotBlank(message = "Este campo não pode estar vazio.")
        @Email(message = "Email inválido.")
        String email,

        @NotBlank(message = "Este campo não pode estar vazio.")
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull(message = "Este campo não pode ser nulo.")
        Especialidade especialidade,

        @NotNull @Valid
        CadastrarEndereco endereco) {

    public CadastroMedicos(Medico entidade) {
        this(entidade.getNome(), entidade.getEmail(), entidade.getCrm(), entidade.getEspecialidade(), new CadastrarEndereco(entidade.getEndereco()));
    }

}
