package com.has.etec.projectShelock.entities;


import jakarta.persistence.*;
import org.hibernate.boot.registry.selector.spi.StrategyCreator;



@Entity
@Table(name ="usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;


    private void cadastrar(){}

    private void  consultarResultado(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
