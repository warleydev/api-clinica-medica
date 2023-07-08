package com.warleydev.apimedic.controllers;

import com.warleydev.apimedic.dto.consultas.DadosAgendamentoConsulta;
import com.warleydev.apimedic.dto.consultas.DetalhesConsulta;
import com.warleydev.apimedic.services.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService service;

    @PostMapping
    public ResponseEntity<DetalhesConsulta> agendar(@RequestBody DadosAgendamentoConsulta dto){
        System.out.println(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id")
                .buildAndExpand(1L).toUri();
        service.agendarConsulta(dto);
        return ResponseEntity.created(uri).body(new DetalhesConsulta(null, dto.idMedico(), dto.idPaciente(), dto.data()));
    }
}
