package com.ultima.vez.consenso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ultima.vez.consenso.model.Login;
import com.ultima.vez.consenso.model.Usuario;
import com.ultima.vez.consenso.service.UsuarioService;

@CrossOrigin(origins = "*")
@RestController

public class LoginController {
    @PostMapping("/login")
    public ResponseEntity<Object> credenciais(@RequestBody Login login) {

        try {
            Usuario verificacaoEmail = usuarioService.findByEmail(login.getEmail()).get();
            if (verificacaoEmail.getSenha().equals(login.getSenha())) {
                return ResponseEntity.status(HttpStatus.ACCEPTED).body("Login Aceito!");
            } else {
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Login errado!");
            }
        } catch (RuntimeException erroLogin) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroLogin.getMessage());
        }

    }

    @Autowired
    UsuarioService usuarioService;
}


