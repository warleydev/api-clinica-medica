package com.warleydev.apimedic.services;

import com.warleydev.apimedic.dto.endereco.CadastrarEndereco;
import com.warleydev.apimedic.dto.medicos.DetalhesMedicos;
import com.warleydev.apimedic.dto.medicos.AtualizarMedico;
import com.warleydev.apimedic.dto.medicos.BuscarMedicos;
import com.warleydev.apimedic.dto.medicos.CadastrarMedico;
import com.warleydev.apimedic.entities.Endereco;
import com.warleydev.apimedic.entities.Medico;
import com.warleydev.apimedic.repositories.MedicoRepository;
import com.warleydev.apimedic.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MedicoService {

    @Autowired
    MedicoRepository repository;


    @Transactional(readOnly = true)
    public DetalhesMedicos buscarPorId(Long id) {
        return new DetalhesMedicos(repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Médico não encontrado!")));
    }

    @Transactional
    public CadastrarMedico salvar(Medico entidade) {
        entidade = repository.save(entidade);
        return new CadastrarMedico(entidade);
    }

    @Transactional(readOnly = true)
    public Page<BuscarMedicos> buscarTodosMedicos(PageRequest pageRequest) {
        return repository.findAllByAtivoTrue(pageRequest).map(x -> new BuscarMedicos(x));
    }

    @Transactional
    public void atualizarMedico(Long id, AtualizarMedico medicoAtualizado) {
        try{
            Medico entidade = repository.getReferenceById(id);
            atualizarDadosMedico(entidade, medicoAtualizado);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Médico não encontrado! Id: "+id);
        }

    }

    @Transactional
    public void excluirMedico(Long id){
        Medico entidade = repository.getReferenceById(id);
        entidade.setAtivo(false);
    }


    public void atualizarDadosMedico(Medico entidade, AtualizarMedico dto) {
        if (dto.nome() != null) {
            entidade.setNome(dto.nome());
        }
        if (dto.telefone() != null) {
            entidade.setTelefone(dto.telefone());
        }
        if (dto.endereco() != null) {
            atualizarDadosEndereco(entidade.getEndereco(), dto.endereco());
        }
    }

    public void atualizarDadosEndereco(Endereco entidade, CadastrarEndereco dto) {
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
