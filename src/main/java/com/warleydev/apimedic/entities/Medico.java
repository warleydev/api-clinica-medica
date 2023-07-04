package com.warleydev.apimedic.entities;

import com.warleydev.apimedic.dto.CadastroMedicos;
import com.warleydev.apimedic.entities.enums.Especialidade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity(name = "Medico")
@Table(name = "medicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Medico(CadastroMedicos dto) {
        nome = dto.nome();
        email = dto.email();
        crm = dto.crm();
        especialidade = dto.especialidade();
        endereco = new Endereco(dto.endereco());
        telefone = dto.telefone();
    }
}
