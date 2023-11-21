package com.app.ifestas.dao;


import org.springframework.data.repository.CrudRepository;

import com.app.ifestas.model.Evento;

public interface EventoDAO extends CrudRepository<Evento, Integer> {

    public Evento findById(int id);
    // public List<Evento> findByAllUsu
    
}
