package com.app.ifestas.dao;

import com.app.ifestas.model.Convidados;


import org.springframework.data.repository.CrudRepository;

public interface ConvidadosDAO extends  CrudRepository<Convidados, Integer> {

    public Convidados findById(int id);
    
}
