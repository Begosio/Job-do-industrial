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
    @Column(name="id_caso")
    private Long id;
    private String titulo;
    private String descricao;
    @Column(name = "alternativas", nullable = false)
    private String alternativas;
}