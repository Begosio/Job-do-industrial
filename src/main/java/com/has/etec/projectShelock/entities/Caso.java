package com.has.etec.projectShelock.entities;

import com.has.etec.projectShelock.enumeration.TipoCaso;
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
    @Column(name = "id_caso")
    private Long id;

    private String titulo;

    @Enumerated(EnumType.STRING)
    private TipoCaso tipo;
}