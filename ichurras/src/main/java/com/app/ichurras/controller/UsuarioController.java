package com.app.ichurras.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.ichurras.dao.UsuarioDAO;
import com.app.ichurras.model.Usuario;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioDAO usuarioDao;

    
    // ENDPOINT LOGIN => Chamar passando  EMAIL e SENHA
    @PostMapping("/login")
    public ResponseEntity<Usuario> fazerLogin(@RequestBody Usuario usuarioRecebido) {
        Usuario usuarioEncontrado = usuarioDao.findByEmailAndSenha(usuarioRecebido.getEmail(), usuarioRecebido.getSenha());
        if (usuarioEncontrado != null) {
            usuarioEncontrado.setSenha("****");
            return ResponseEntity.ok(usuarioEncontrado);
        } else {
            return ResponseEntity.status(403).build();
        }
    }

    // ENDPOINT CADASTRAR => Chamar passando  Todos os campos menos o ID
    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuarioRecebido) {
        Usuario usuarioEncontrado = usuarioDao.findByEmail(usuarioRecebido.getEmail());
        if (usuarioEncontrado != null) {
            return ResponseEntity.status(403).build();
        } else {
            Usuario novoUsuario = usuarioDao.save(usuarioRecebido);
            return ResponseEntity.ok(novoUsuario);
        }         
    }

    // ENDPOINT ATUALIZAR => Chamar passando  Todos os campos INCLUSIVE o ID
    @PutMapping("/atualizar")
    public ResponseEntity<Usuario> atualizarUsuario(@RequestBody Usuario usuarioRecebido) {
        Usuario usuarioEncontrado = usuarioDao.findById(usuarioRecebido.getId());
        if (usuarioEncontrado != null) {
            Usuario novoUsuario = usuarioDao.save(usuarioRecebido);
            return ResponseEntity.ok(novoUsuario);
        } else {
            return ResponseEntity.status(404).build();
        }      
    }

    
    // ENDPOINT BUSCAR ID => Chamar passando  o ID do usuario vindo pelo URL
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable int id) {
        Usuario UsuarioEncontrado = usuarioDao.findById(id);
        UsuarioEncontrado.setSenha("****");
        return ResponseEntity.ok(UsuarioEncontrado);      
    }

    // ENDPOINT BUSCAR EMAIL => Chamar passando  o EMAIL do usuario pelo URL por QUERY STRINGS
    @GetMapping("/buscar")
    public ResponseEntity<Usuario> buscarUsuarioPorEmail(@RequestParam(name = "email") String email) {
        Usuario UsuarioEncontrado = usuarioDao.findByEmail(email);
        UsuarioEncontrado.setSenha("****");
        return ResponseEntity.ok(UsuarioEncontrado);      
    }

    // Procurar por todos os  usuarios
    @GetMapping("/todos")
    public List<Usuario> buscarTodos() {
        List<Usuario> ListaDeUsuarios = (List<Usuario>)usuarioDao.findAll();
        return ListaDeUsuarios;      
    }

    // Excluir  um usuario especifico
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Usuario> excluirUsuario(@PathVariable int id) {
        Usuario usuarioEncontrado = usuarioDao.findById(id);
        if (usuarioEncontrado != null) {
            usuarioDao.delete(usuarioEncontrado);
            return ResponseEntity.ok(usuarioEncontrado);
        } else {
            return ResponseEntity.status(403).build();
        }
    }

}
