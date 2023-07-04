package com.warleydev.apimedic.services;

import com.warleydev.apimedic.dto.endereco.CadastrarEndereco;
import com.warleydev.apimedic.dto.pacientes.AtualizarPaciente;
import com.warleydev.apimedic.dto.pacientes.BuscarPacientes;
import com.warleydev.apimedic.dto.pacientes.CadastroPaciente;
import com.warleydev.apimedic.dto.pacientes.DetalhesPaciente;
import com.warleydev.apimedic.entities.Endereco;
import com.warleydev.apimedic.entities.Paciente;
import com.warleydev.apimedic.repositories.PacienteRepository;
import com.warleydev.apimedic.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    @Transactional(readOnly = true)
    public DetalhesPaciente buscarPacienteDetalhadoPorId(Long id) {
        try{
            Paciente entidade = repository.findById(id).get();
            return new DetalhesPaciente(entidade);
        }
        catch (NoSuchElementException e){
            throw new ResourceNotFoundException("Paciente não encontrado! Id: " + id);
        }

    }

    @Transactional
    public CadastroPaciente salvar(Paciente entidade){
        entidade = repository.save(entidade);
        return new CadastroPaciente(entidade);
    }

    @Transactional(readOnly = true)
    public Page<BuscarPacientes> buscandoTodosPacientes(PageRequest pageRequest){
        return repository.findAllByAtivoTrue(pageRequest).map(x -> new BuscarPacientes(x));
    }

    @Transactional
    public DetalhesPaciente atualizarPaciente(Long id, AtualizarPaciente dto){
        try{
            Paciente entidade = repository.getReferenceById(id);
            atualizarDados(entidade, dto);
            repository.save(entidade);
            return new DetalhesPaciente(entidade);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Paciente não encontrado! Id: " + id);
        }
    }

    @Transactional
    public void excluirPaciente(Long id){
        Paciente entidade = repository.getReferenceById(id);
        entidade.setAtivo(false);
    }

    private void atualizarDados(Paciente entidade, AtualizarPaciente dto) {
        if (dto.nome() != null) {
            entidade.setNome(dto.nome());
        }
        if (dto.telefone() != null) {
            entidade.setTelefone(dto.telefone());
        }
        if (dto.endereco() != null) {
            atualizarEndereco(entidade.getEndereco(), dto.endereco());
        }
    }

    private void atualizarEndereco(Endereco entidade, CadastrarEndereco dto) {
        if (dto.logradouro() != null) {
            entidade.setLogradouro(dto.logradouro());
        }
        if (dto.cep() != null) {
            entidade.setCep(dto.cep());
        }
        if (dto.uf() != null) {
            entidade.setUf(dto.uf());
        }
        if (dto.bairro() != null) {
            entidade.setBairro(dto.bairro());
        }
        if (dto.complemento() != null) {
            entidade.setComplemento(dto.complemento());
        }
        if (dto.cidade() != null) {
            entidade.setCidade(dto.cidade());
        }
        if (dto.numero() != null) {
            entidade.setNumero(dto.numero());
        }
    }
}
