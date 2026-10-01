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

}
