package com.warleydev.apimedic.dto.pacientes;

import com.warleydev.apimedic.dto.endereco.CadastrarEndereco;
import com.warleydev.apimedic.entities.Paciente;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CadastroPaciente (
        @NotBlank(message = "Este campo não pode estar vazio.")
        String nome,
        @NotBlank(message = "Este campo não pode estar vazio.")
        @Email(message = "Email inválido.")
        String email,

        @NotBlank(message = "Este campo não pode estar vazio;")
        String telefone,
        @NotBlank(message = "Este campo não pode estar vazio.")
        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}", message = "CPF inválido.")
        String cpf,

        @NotNull(message = "Este campo não pode ser nulo.")
        @Valid
        CadastrarEndereco endereco
){
        public CadastroPaciente(Paciente entidade){
                this(entidade.getNome(), entidade.getEmail(), entidade.getTelefone(), entidade.getCpf(), new CadastrarEndereco(entidade.getEndereco()));
        }
}
