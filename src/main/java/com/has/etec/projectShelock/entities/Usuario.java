package com.has.etec.projectShelock.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.boot.registry.selector.spi.StrategyCreator;


@Getter
@Setter
@Entity
@Table(name ="Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idUsuario")
    private Long id;
    @Column(name="nomeUsuario")
    private String nome;

    private void  consultarResultado(){}

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
