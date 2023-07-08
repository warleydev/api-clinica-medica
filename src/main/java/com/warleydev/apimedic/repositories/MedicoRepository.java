package com.warleydev.apimedic.repositories;

import com.warleydev.apimedic.entities.Medico;
import com.warleydev.apimedic.entities.enums.Especialidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByAtivoTrue(PageRequest pageRequest);

    @Query("""
        select m from Medico m
        where
            m.ativo = CAST(:ativo AS boolean)
        and
        m.especialidade = :especialidade
        and
        m.id not in(
            select c.medico.id from Consulta c
            where
            c.data = :data
        )
        order by rand()
        limit 1
        """)
    Medico buscarMedicoAleatorioPorEspecialidadeDisponibilidade(@Param("ativo") boolean ativo, Especialidade especialidade, LocalDateTime data);


    @Query("""
            select m.ativo
            from Medico m
            where
            m.id = :id
            """)
    Boolean findAtivoById(Long id);

    List<Medico> findByAtivoAndEspecialidade(boolean ativo, Especialidade especialidade);
}
