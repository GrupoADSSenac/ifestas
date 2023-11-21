package com.app.ifestas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ifestas.dao.ConvidadosDAO;
import com.app.ifestas.model.Convidados;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/convidados")
public class ConvidadosController {

    @Autowired
    private ConvidadosDAO convidadoDao;

    
    // ENDPOINT CADASTRAR => Chamar passando  Todos os campos menos o ID
    @PostMapping("/cadastrar")
    public ResponseEntity<Convidados> cadastrarConvidado(@RequestBody Convidados convidadoRecebido) {
        Convidados novoconvidado = convidadoDao.save(convidadoRecebido);
        return ResponseEntity.ok(novoconvidado);        
    }

    
    // ENDPOINT Atualizar => Chamar passando  Todos os campos inclusive o ID
    @PutMapping("/atualizar")
    public ResponseEntity<Convidados> alterarConvidados(@RequestBody Convidados convidadoRecebido) {
        Convidados convidadoEncontrado = convidadoDao.findById(convidadoRecebido.getId());
        if (convidadoEncontrado != null) {
            Convidados novoconvidado = convidadoDao.save(convidadoRecebido);
            return ResponseEntity.ok(novoconvidado);  
        } else {
            return ResponseEntity.status(404).build();
        }     
    }


    // ENDPOINT Buscar todos
    @GetMapping("/buscar/todos")
    public List<Convidados> buscarTodos() {
        return (List<Convidados>)convidadoDao.findAll();
    }
    

    // ENDPOINT Buscar por ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Convidados> buscarPorId(@PathVariable int id) {
        Convidados convidadoEncontrado = convidadoDao.findById(id);
        if (convidadoEncontrado != null) {
            return ResponseEntity.ok(convidadoEncontrado);  
        } else {
            return ResponseEntity.status(404).build();
        }     
    }


    // Excluir  um usuario especifico
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Convidados> excluirConvidados(@PathVariable int id) {
        Convidados convidadoEncontrado = convidadoDao.findById(id);
        if (convidadoEncontrado != null) {
            convidadoDao.delete(convidadoEncontrado);
            return ResponseEntity.ok(convidadoEncontrado);
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    
}
