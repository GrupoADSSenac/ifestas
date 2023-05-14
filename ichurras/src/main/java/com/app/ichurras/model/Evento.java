package com.app.ichurras.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome", length = 255, nullable = false)
    private String nome;

    @Column(name = "data_evento")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataEvento;

    
    @Column(name = "hora_evento")
    private LocalTime horaEvento;

    
    @Column(name = "endereco")
    private String endereco;


    @Column(name = "valor_total_evento")
    private long valorTotalEvento;

    @OneToMany(mappedBy = "evento")
    @JsonIgnoreProperties("evento")
    private List<Convidados> convidados;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnoreProperties("eventos")
    private Usuario usuario;


    public Evento() {
    }

    

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataEvento() {
        return this.dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public LocalTime getHoraEvento() {
        return this.horaEvento;
    }

    public void setHoraEvento(LocalTime horaEvento) {
        this.horaEvento = horaEvento;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public long getValorTotalEvento() {
        return this.valorTotalEvento;
    }

    public void setValorTotalEvento(long valorTotalEvento) {
        this.valorTotalEvento = valorTotalEvento;
    }

    public List<Convidados> getConvidados() {
        return this.convidados;
    }

    public void setConvidados(List<Convidados> convidados) {
        this.convidados = convidados;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    


}
