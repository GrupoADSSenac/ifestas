package com.app.ichurras.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.app.ichurras.model.ControlePagamentos;
import com.app.ichurras.model.Evento;
import com.app.ichurras.model.Usuario;

public interface ControlePagamentosDAO extends CrudRepository<ControlePagamentos, Integer>{

    // public List<ControlePagamentos> findByUsuarioId(int id);
    // public List<ControlePagamentos> findByEventoId(int id);
    // public List<ControlePagamentos> findByPagoAndUsuario(Boolean pago, Usuario usuario);
    
}
