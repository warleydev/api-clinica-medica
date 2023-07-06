package com.warleydev.apimedic.controllers;

import com.warleydev.apimedic.config.TokenService;
import com.warleydev.apimedic.dto.autenticacao.DadosAutenticacao;
import com.warleydev.apimedic.dto.autenticacao.DadosTokenJWT;
import com.warleydev.apimedic.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService service;

    @PostMapping
    public ResponseEntity fazerLogin(@RequestBody DadosAutenticacao dto){

        var token = new UsernamePasswordAuthenticationToken(dto.login(), dto.senha());
        var authentication = manager.authenticate(token);
        var authenticationToken = service.gerarToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWT(authenticationToken));
    }
}
