package com.app.ichurras.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.app.ichurras.dao.EventoDAO;
import com.app.ichurras.model.Evento;

@RestController
@CrossOrigin("*")
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    private EventoDAO eventoDao;


    // ENDPOINT CADASTRAR => Chamar passando  Todos os campos menos o ID
    @PostMapping("/cadastrar")
    public ResponseEntity<Evento> cadastrarEvento(@RequestBody Evento eventoRecebido) {
        Evento novoEvento = eventoDao.save(eventoRecebido);
        return ResponseEntity.ok(novoEvento);        
    }

    
    // ENDPOINT Atualizar => Chamar passando  Todos os campos inclusive o ID
    @PostMapping("/atualizar")
    public ResponseEntity<Evento> alterarEvento(@RequestBody Evento eventoRecebido) {
        Evento eventoEncontrado = eventoDao.findById(eventoRecebido.getId());
        if (eventoEncontrado != null) {
            Evento novoEvento = eventoDao.save(eventoRecebido);
            return ResponseEntity.ok(novoEvento);  
        } else {
            return ResponseEntity.status(404).build();
        }     
    }


    // ENDPOINT Buscar todos
    @GetMapping("/buscar/todos")
    public List<Evento> buscarTodos() {
        return (List<Evento>)eventoDao.findAll();
    }
    

    // ENDPOINT Buscar por ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Evento> buscarPorId(@PathVariable int id) {
        Evento eventoEncontrado = eventoDao.findById(id);
        if (eventoEncontrado != null) {
            return ResponseEntity.ok(eventoEncontrado);  
        } else {
            return ResponseEntity.status(404).build();
        }     
    }


    // Excluir  um usuario especifico
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Evento> excluirEvento(@PathVariable int id) {
        Evento eventoEncontrado = eventoDao.findById(id);
        if (eventoEncontrado != null) {
            eventoDao.delete(eventoEncontrado);
            return ResponseEntity.ok(eventoEncontrado);
        } else {
            return ResponseEntity.status(404).build();
        }
    }


}
