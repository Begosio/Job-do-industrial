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
    @ManyToOne
    @JoinColumn(name = "tentativa_id")
    private Tentativa tentativa;
    private int posicao;
    private int tempo;
    @Column(name = "pontuacao_final", nullable = false)
    private int pontuacaoFinal;
}
