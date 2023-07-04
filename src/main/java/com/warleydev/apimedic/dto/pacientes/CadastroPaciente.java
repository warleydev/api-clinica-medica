package com.warleydev.apimedic.dto.pacientes;

import com.warleydev.apimedic.dto.endereco.CadastrarEndereco;
import com.warleydev.apimedic.entities.Paciente;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CadastroPaciente (
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")
        String cpf,

        @NotNull
        @Valid
        CadastrarEndereco endereco
){
        public CadastroPaciente(Paciente entidade){
                this(entidade.getNome(), entidade.getEmail(), entidade.getTelefone(), entidade.getCpf(), new CadastrarEndereco(entidade.getEndereco()));
        }
}
