package com.has.etec.projectShelock.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Caso")
public class Caso {
    @Id
    @Column(name="idCaso")
    private Long id;
    private String titulo;
    private String descricao;
    private List<String> alternativas;
}