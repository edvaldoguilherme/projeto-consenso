package com.ultima.vez.consenso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ultima.vez.consenso.model.Usuario;
import com.ultima.vez.consenso.service.UsuarioService;

@CrossOrigin(origins = "*")
@RestController

public class UsuarioController {
    @PostMapping("/usuario")

    public ResponseEntity<Object> criarNovoUsuario(@RequestBody Usuario usuario) {

        try {
            if (usuario.getTipoUsuario().getIdTipoUsuario() == 1
                    || usuario.getTipoUsuario().getIdTipoUsuario() == 2) {
                usuarioService.save(usuario);
                return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(usuario.getTipoUsuario().getNome());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());// string
        }

    }

    @GetMapping("/usuario")
    public List<Usuario> obterTodosUsuarios() {
        return usuarioService.findAll();
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Object> obterUsuarioPeloId(@PathVariable("id") Integer id) {
        try {

            return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findById(id).get());
        } catch (RuntimeException erro) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro.getMessage());

        }

    }

    @DeleteMapping("/usuario/{id}")
    public String deletarUsuarioPeloId(@PathVariable("id") Integer id) {
        usuarioService.deleteById(id);

        return "Usuario deletado com sucesso!";
    }

    @PutMapping("/usuario")
    public Usuario atualizarContato(@RequestBody Usuario usuario) {
        Usuario usuarioAtualizar = usuarioService.findById(usuario.getIdUsuario()).get();

        usuarioAtualizar.setNome(usuario.getNome());
        usuarioAtualizar.setSobrenome(usuario.getSobrenome());
        usuarioAtualizar.setEmail(usuario.getEmail());
        usuarioAtualizar.setSenha(usuario.getSenha());
        usuarioAtualizar.setTipoUsuario(usuario.getTipoUsuario());
        usuarioAtualizar = usuarioService.save(usuario);


        return usuarioAtualizar;
    }

    @Autowired
    private UsuarioService usuarioService;

}
    

