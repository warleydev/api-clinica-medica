package com.warleydev.apimedic.controllers;


import com.warleydev.apimedic.dto.BuscarMedicos;
import com.warleydev.apimedic.dto.CadastroMedicos;
import com.warleydev.apimedic.entities.Medico;
import com.warleydev.apimedic.repositories.MedicoRepository;
import com.warleydev.apimedic.services.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    MedicoService service;

    @PostMapping
    public ResponseEntity<CadastroMedicos> cadastrar(@RequestBody @Valid CadastroMedicos dto){
        service.save(new Medico(dto));
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<BuscarMedicos>> buscarTodosMedicos(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "ASC") String direction,
            @RequestParam(defaultValue = "nome") String sortBy
    ){
        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.Direction.valueOf(direction), sortBy);
        return ResponseEntity.ok(service.searchAll(pageRequest));
    }

}
