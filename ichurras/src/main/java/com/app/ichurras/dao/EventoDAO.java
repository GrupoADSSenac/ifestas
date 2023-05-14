package com.app.ichurras.dao;


import org.springframework.data.repository.CrudRepository;

import com.app.ichurras.model.Evento;

public interface EventoDAO extends CrudRepository<Evento, Integer> {

    public Evento findById(int id);
    // public List<Evento> findByAllUsu
    
}
