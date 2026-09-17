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
    private int idResultado;
    private int idUsuario;
    private int idCaso;
    private int acertos;
    private int erros;
    private int pontuacao;
}
