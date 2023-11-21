package com.app.ifestas.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.app.ifestas.model.Evento;
import com.app.ifestas.model.Usuario;


public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{

    public Usuario findById(int id);
    public Usuario findByEmail(String email);
    public Usuario findByEmailAndSenha(String email, String senha);
    public List<Evento> findAllById(int id);

}
