package com.app.ichurras.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.app.ichurras.model.Evento;
import com.app.ichurras.model.Usuario;

public interface EventoDAO extends CrudRepository<Evento, Integer> {

    // public Evento findByEventoId(int id);
    // public List<Evento> findByAllUsu
    
}
