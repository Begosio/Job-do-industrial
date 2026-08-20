package com.has.etec.projectShelock.entities;


import jakarta.persistence.*;
import org.hibernate.boot.registry.selector.spi.StrategyCreator;


// diz para o JPA que
// essa classe é uma tabela
// e define o nome da tabela no banco de dados
@Entity
@Table(name ="usuario")
public class Usuario {

    // auto increment
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;


}
