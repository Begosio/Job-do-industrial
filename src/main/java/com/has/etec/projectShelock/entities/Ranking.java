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
    @Column(name = "id_ranking")
    private Long id;

    @Column(name = "tentativa_id")
    private Long tentativaId;

    @Column(name = "posicao")
    private int posicao;

    @Column(name = "tempo")
    private int tempo;

    @Column(name = "pontuacao_final")
    private int pontuacaoFinal;
}