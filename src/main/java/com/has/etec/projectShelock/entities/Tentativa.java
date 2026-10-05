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
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Caso caso;
    @Column(nullable = false)
    private int tempo;
    @Column(nullable = false)
    private boolean acertou;
    @Column(name = "pontuacao_final", nullable = false)
    private int pontuacaoFinal;
}
