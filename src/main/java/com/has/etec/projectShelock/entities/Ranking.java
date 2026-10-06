package com.has.etec.projectShelock.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ranking")
public class Ranking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long tentativaId;
    private int posicao;
    private int tempo;
    @Column(name = "pontuacao_final")
    private int pontuacaoFinal;
}