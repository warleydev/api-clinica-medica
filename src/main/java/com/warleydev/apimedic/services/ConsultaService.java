package com.warleydev.apimedic.services;

import com.warleydev.apimedic.dto.consultas.DadosAgendamentoConsulta;
import com.warleydev.apimedic.entities.Consulta;
import com.warleydev.apimedic.entities.Medico;
import com.warleydev.apimedic.repositories.ConsultaRepository;
import com.warleydev.apimedic.repositories.MedicoRepository;
import com.warleydev.apimedic.repositories.PacienteRepository;
import com.warleydev.apimedic.services.exceptions.ResourceNotFoundException;
import com.warleydev.apimedic.services.utils.ValidarAntecedencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConsultaService {

    @Autowired
    ConsultaRepository consultaRepository;

    @Autowired
    MedicoRepository medicoRepository;

    @Autowired
    PacienteRepository pacienteRepository;

    @Transactional
    public void agendarConsulta(DadosAgendamentoConsulta dto){
        if (!pacienteRepository.existsById(dto.idPaciente())){
            throw new ResourceNotFoundException("Paciente não encontrado! Id: " + dto.idPaciente());
        }
        if (dto.idMedico() != null && !medicoRepository.existsById(dto.idMedico())){
            throw new ResourceNotFoundException("Médico não encontrado! Id: " + dto.idMedico());
        }

        var medico = medicoRepository.findById(dto.idMedico()).get();
        var paciente = pacienteRepository.getReferenceById(dto.idPaciente());
        Consulta consulta = new Consulta(null, medico, paciente, dto.data());
        consultaRepository.save(consulta);
    }

    private Medico escolhaDeMedico(DadosAgendamentoConsulta dto){
        if (dto.idMedico() != null){
            return medicoRepository.getReferenceById(dto.idMedico());
        }
        if (dto.especialidade() == null){
            throw new ResourceNotFoundException("Você deve informar a área de atendimento, quando não há preferência de médico.");
        }

        return medicoRepository.buscarMedicoAleatorioPorEspecialidadeEDisponibilidade(dto.especialidade(), dto.data());
    }

}
