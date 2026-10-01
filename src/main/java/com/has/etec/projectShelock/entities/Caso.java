package com.has.etec.projectShelock.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Caso")
public class Caso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCaso")
    private Long id;
    private String tipo;
    private String titulo;
    private String descricao;
}