package com.warleydev.apimedic.repositories;

import com.warleydev.apimedic.entities.Medico;
import com.warleydev.apimedic.entities.enums.Especialidade;
import io.micrometer.observation.ObservationFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByAtivoTrue(PageRequest pageRequest);

    @Query("""
            select m from Medico m
            where m.ativo = 1
            and
            m.especialidade == :especialidade
            and
            m.id not in(
                select c.medico.id from Consulta c
                where c.data = :data
            )
            order by rand()
            limit 1
            """)
    Medico buscarMedicoAleatorioPorEspecialidadeEDisponibilidade(Especialidade especialidade, LocalDateTime data);
}
