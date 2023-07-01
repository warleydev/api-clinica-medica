package com.warleydev.apimedic.controllers;


import com.warleydev.apimedic.dto.CadastroMedicos;
import com.warleydev.apimedic.entities.Medico;
import com.warleydev.apimedic.repositories.MedicoRepository;
import com.warleydev.apimedic.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    MedicoService service;

    @PostMapping
    public ResponseEntity<CadastroMedicos> cadastrar(@RequestBody CadastroMedicos dto){
        service.save(new Medico(dto));
        return ResponseEntity.ok(dto);
    }

}
