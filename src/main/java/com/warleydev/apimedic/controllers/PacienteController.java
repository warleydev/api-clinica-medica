package com.warleydev.apimedic.controllers;

import com.warleydev.apimedic.dto.pacientes.AtualizarPaciente;
import com.warleydev.apimedic.dto.pacientes.BuscarPacientes;
import com.warleydev.apimedic.dto.pacientes.CadastroPaciente;
import com.warleydev.apimedic.dto.pacientes.DetalhesPaciente;
import com.warleydev.apimedic.entities.Paciente;
import com.warleydev.apimedic.services.PacienteService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/pacientes")
@SecurityRequirement(name = "bearer-key")

public class PacienteController {

    @Autowired
    private PacienteService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<DetalhesPaciente> buscarPacienteDetalhadoPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPacienteDetalhadoPorId(id));
    }

    @PostMapping
    public ResponseEntity<DetalhesPaciente> salvar(@RequestBody @Valid CadastroPaciente dto){
        Paciente entidade = new Paciente(dto);
        service.salvar(entidade);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(entidade.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhesPaciente(entidade));
    }

    @GetMapping
    public ResponseEntity<Page<BuscarPacientes>> buscandoTodosPacientes(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "ASC") String direction,
            @RequestParam(defaultValue = "nome") String sortBy
    ){
        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.Direction.valueOf(direction), sortBy);
        return ResponseEntity.ok(service.buscandoTodosPacientes(pageRequest));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DetalhesPaciente> atualizandoPaciente(@PathVariable Long id, @RequestBody AtualizarPaciente dto){

        service.atualizarPaciente(id, dto);
        return ResponseEntity.ok(buscarPacienteDetalhadoPorId(id).getBody());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> excluirPaciente(@PathVariable Long id){
        service.excluirPaciente(id);
        return ResponseEntity.noContent().build();
    }

}
