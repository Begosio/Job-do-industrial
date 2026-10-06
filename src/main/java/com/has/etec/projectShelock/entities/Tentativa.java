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
    @Column(name = "tentativa_id")
    private Long id;

    @Column(name = "id_usuario")
    private Long usuarioId;

    @Column(name = "id_caso")
    private Long casoId;

    @Column(name = "tempo")
    private int tempo;

    @Column(name = "acertou")
    private boolean acertou;

    @Column(name = "pontuacao_final")
    private int pontuacaoFinal;

    public int calcularPontuacaoBase() {
        return this.acertou ? 3 : 0;
    }
}