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
    @OneToOne
    @JoinColumn(name = "tentativa_id", nullable = false)
    private Tentativa tentativa;
    @Column(nullable = false)
    private int posicao;

    @Column(nullable = false)
    private int tempo;
    @Column(name = "pontuacao_final", nullable = false)
    private int pontuacaoFinal;
}
