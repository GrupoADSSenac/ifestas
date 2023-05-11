package com.app.ichurras.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="email", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name="nome", length = 100, nullable = false)
    private String nome;

    @Column(name="senha", length = 30, nullable = false)
    private String senha;

    @Column(name="telefone", length = 13, nullable = false)
    private String telefone;

    
    

    public Usuario(int id, String email, String nome, String senha, String telefone) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.telefone = telefone;
    }
     
    public Usuario() {
    }
        



    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


}

