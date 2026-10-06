package com.has.etec.projectShelock.controllers;

import com.has.etec.projectShelock.dtos.tentativa.TentativaRequest;
import com.has.etec.projectShelock.entities.Tentativa;
import com.has.etec.projectShelock.services.TentativaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tentativa")
public class TentativaController {

    public final TentativaService tentativaService;

    public TentativaController(TentativaService tentativaService) {
        this.tentativaService = tentativaService;
    }

    @PostMapping
    public Tentativa enviarTentativa(@RequestBody TentativaRequest tentativa) {
        return tentativaService.salvarTentativa(tentativa);
    }

    @GetMapping
    public List<Tentativa> buscaTentativas() {
        return tentativaService.buscarTentativa();
    }
}
