package com.warleydev.apimedic.dto.medicos;

import com.warleydev.apimedic.dto.endereco.CadastrarEndereco;
import com.warleydev.apimedic.entities.Medico;
import com.warleydev.apimedic.entities.enums.Especialidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CadastrarMedico(

        @NotBlank(message = "Este campo não pode estar vazio.")
        String nome,

        @NotBlank(message = "Este campo não pode estar vazio.")
        @Email(message = "Email inválido.")
        String email,

        @NotBlank(message = "Este campo não pode estar vazio;")
        String telefone,

        @NotBlank(message = "Este campo não pode estar vazio.")
        @Pattern(regexp = "\\d{4,6}", message = "Deve conter entre 4 e 6 caracteres.")
        String crm,

        @NotNull(message = "Este campo não pode ser nulo.")
        Especialidade especialidade,

        @NotNull @Valid
        CadastrarEndereco endereco) {

    public CadastrarMedico(Medico entidade) {
        this(entidade.getNome(), entidade.getEmail(), entidade.getTelefone(), entidade.getCrm(), entidade.getEspecialidade(), new CadastrarEndereco(entidade.getEndereco()));
    }

}
