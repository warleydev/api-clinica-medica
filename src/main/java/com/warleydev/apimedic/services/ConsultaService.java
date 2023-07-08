package com.warleydev.apimedic.services;

import com.warleydev.apimedic.dto.consultas.DadosAgendamentoConsulta;
import com.warleydev.apimedic.dto.consultas.DetalhesConsulta;
import com.warleydev.apimedic.entities.Consulta;
import com.warleydev.apimedic.entities.Medico;
import com.warleydev.apimedic.entities.enums.Especialidade;
import com.warleydev.apimedic.repositories.ConsultaRepository;
import com.warleydev.apimedic.repositories.MedicoRepository;
import com.warleydev.apimedic.repositories.PacienteRepository;
import com.warleydev.apimedic.services.exceptions.ResourceNotFoundException;
import com.warleydev.apimedic.services.utils.ValidarAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class ConsultaService {

    @Autowired
    ConsultaRepository consultaRepository;

    @Autowired
    MedicoRepository medicoRepository;

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    private List<ValidarAgendamentoConsulta> validadores;

    @Transactional
    public DetalhesConsulta agendarConsulta(DadosAgendamentoConsulta dto){

        if (!pacienteRepository.existsById(dto.idPaciente())){
            throw new ResourceNotFoundException("Paciente não encontrado! Id: " + dto.idPaciente());
        }
        if (dto.idMedico() != null && !medicoRepository.existsById(dto.idMedico())){
            throw new ResourceNotFoundException("Médico não encontrado! Id: " + dto.idMedico());
        }

        validadores.forEach(v -> v.validar(dto));

        var medico = medicoRepository.getReferenceById(dto.idMedico());
        var medico2 = escolhaDeMedico(medico.getEspecialidade(), dto.data());
        var paciente = pacienteRepository.getReferenceById(dto.idPaciente());
        Consulta consulta = new Consulta(null, medico2, paciente, dto.data());
        consultaRepository.save(consulta);
        return new DetalhesConsulta(consulta);
    }

    public Medico escolhaDeMedico(Especialidade especialidade, LocalDateTime data) {
        List<Medico> medicos = medicoRepository.findByAtivoAndEspecialidade(true, especialidade);
        List<Consulta> consultas = consultaRepository.findByData(data);

        // Filtra os médicos que não possuem consultas na data especificada
        medicos = medicos.stream()
                .filter(medico -> consultas.stream().noneMatch(consulta -> consulta.getMedico().getId().equals(medico.getId())))
                .collect(Collectors.toList());

        // Obtém um médico aleatório
        if (!medicos.isEmpty()) {
            int randomIndex = new Random().nextInt(medicos.size());
            return medicos.get(randomIndex);
        }

        return null;
    }

}
