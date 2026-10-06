package com.has.etec.projectShelock.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tentativas")
public class Tentativa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long usuarioId;
    private Long casoId;
    private int tempo;
    private boolean acertou;
    @Column(name = "pontuacao_final")
    private int pontuacaoFinal;
    public int calcularPontuacaoBase() {
        return this.acertou ? 3 : 0;
    }
}