package com.has.etec.projectShelock.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "resposta_caso")
public class RespostaCaso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resp")
    private Long id;

    @Column(name = "id_caso")
    private Long casoId;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "correta")
    private boolean correta;
}