package com.ultima.vez.consenso.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ultima.vez.consenso.model.Agendamento;

public interface AgendamentoService extends JpaRepository<Agendamento, Integer> {

    List<Agendamento> findByUsuarioIdUsuario(Integer idusuario);
}
