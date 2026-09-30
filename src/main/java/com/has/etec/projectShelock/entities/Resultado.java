package com.has.etec.projectShelock.entities;

import jakarta.persistence.*;



@Entity
@Table
public class Resultado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idResultado")
    private Long id;
    private int acertos;
    private int erros;
    private int pontuacao;

    // foreign key
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;


    public int calcularPontuacao(){return 0;}

    public int calcularAcertos(){return 0;}


    public Long getId() {
        return id;
    }

    public void setId(Long d) {
        this.id = id;
    }

    public int getAcertos() {
        return acertos;
    }

    public void setAcertos(int acertos) {
        this.acertos = acertos;
    }

    public int getErros() {
        return erros;
    }

    public void setErros(int erros) {
        this.erros = erros;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
}
