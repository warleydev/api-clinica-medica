package com.warleydev.apimedic.controllers;

import com.warleydev.apimedic.dto.BuscarPacientes;
import com.warleydev.apimedic.dto.CadastroPaciente;
import com.warleydev.apimedic.dto.DetalhesPaciente;
import com.warleydev.apimedic.entities.Paciente;
import com.warleydev.apimedic.services.PacienteService;
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
public class PacienteController {

    @Autowired
    private PacienteService service;

    @PostMapping
    public ResponseEntity<DetalhesPaciente> salvar(@RequestBody CadastroPaciente dto){
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

}
