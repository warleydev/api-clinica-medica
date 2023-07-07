package com.warleydev.apimedic.entities;


import com.warleydev.apimedic.dto.consultas.DadosAgendamentoConsulta;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Lazy;

import java.time.LocalDateTime;

@Entity(name = "Consulta")
@Table(name = "consultas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    private LocalDateTime data;


}
