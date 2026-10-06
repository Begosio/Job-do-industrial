package com.has.etec.projectShelock.controllers;

import com.has.etec.projectShelock.entities.Tentativa;
import com.has.etec.projectShelock.services.TentativaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tentativas")
public class TentativaController {

    public TentativaService tentativaService;

    public TentativaController(TentativaService tentativaService) {
        this.tentativaService = tentativaService;
    }
    @PostMapping
    public Tentativa registrarTentativa(
            @RequestParam Long usuarioId,
            @RequestParam Long casoId,
            @RequestParam Long respostaId,
            @RequestParam int tempo) {
        return tentativaService.registrar(usuarioId, casoId, respostaId, tempo);
    }
}