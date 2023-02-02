package com.ultima.vez.consenso.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ultima.vez.consenso.model.TipoUsuario;

public interface TipoUsuarioService extends JpaRepository<TipoUsuario, Integer>{
    
}
