package com.ultima.vez.consenso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ultima.vez.consenso.model.Agendamento;
import com.ultima.vez.consenso.service.AgendamentoService;

@CrossOrigin(origins = "*")
@RestController

public class AgendamentoController {

    @PostMapping("/agendamento")
    public Agendamento criarNovoAgendamento(@RequestBody Agendamento agendamento) {
        return agendamentoService.save(agendamento);
    }

    @GetMapping("/agendamento")
    public List<Agendamento> obterTodosAgendamento() {
        return agendamentoService.findAll();
    }

    @GetMapping("/agendamento/usuario/{id}")
    public List<Agendamento> obterTodosAgendamentosDoUsuario(@PathVariable("id") Integer idusuario) {
        return agendamentoService.findByUsuarioIdUsuario(idusuario);
    }

    @GetMapping("/agendamento/{id}")
    public Agendamento obterAgendamentoPeloId(@PathVariable("id") Integer id) {
        return agendamentoService.findById(id).get();
    }

    @DeleteMapping("/agendamento/{id}")
    public String deletarAgendamentoPeloId(@PathVariable("id") Integer id) {
        agendamentoService.deleteById(id);

        return "Agendamento deletado com sucesso!";
    }

    @PutMapping("/agendamento")
    public Agendamento atualizarAgendamento(@RequestBody Agendamento agendamento) {
        Agendamento agendamentoBD = agendamentoService.findById(agendamento.getIdAgendamento()).get();

        agendamentoBD.setData(agendamento.getData());
        agendamentoBD.setHora(agendamento.getHora());

        agendamentoBD = agendamentoService.save(agendamentoBD);

        return agendamentoBD;
    }

    @Autowired
    private AgendamentoService agendamentoService;
}

    

