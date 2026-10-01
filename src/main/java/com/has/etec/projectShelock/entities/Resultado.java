package com.has.etec.projectShelock.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Resultado")
public class Resultado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResultado;
    private Long  idUsuario;
    private Long  idCaso;
    private int acertos;
    private int erros;
    private int pontuacao;
}