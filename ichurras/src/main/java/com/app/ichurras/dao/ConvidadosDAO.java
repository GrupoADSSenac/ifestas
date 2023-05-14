package com.app.ichurras.dao;

import com.app.ichurras.model.Convidados;


import org.springframework.data.repository.CrudRepository;

public interface ConvidadosDAO extends  CrudRepository<Convidados, Integer> {

    public Convidados findById(int id);
    
}
