package com.warleydev.apimedic.entities;

import com.warleydev.apimedic.dto.medicos.CadastrarMedico;
import com.warleydev.apimedic.entities.enums.Especialidade;
import jakarta.persistence.*;
import lombok.*;


@Entity(name = "Medico")
@Table(name = "medicos")
@Getter
@Setter
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

    private Boolean ativo;

    public Medico(CadastrarMedico dto) {
        nome = dto.nome();
        email = dto.email();
        crm = dto.crm();
        especialidade = dto.especialidade();
        endereco = new Endereco(dto.endereco());
        telefone = dto.telefone();
        ativo = true;
    }
}
