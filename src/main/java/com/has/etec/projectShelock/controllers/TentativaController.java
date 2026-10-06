package com.has.etec.projectShelock.controllers;

import com.has.etec.projectShelock.entities.Tentativa;
import com.has.etec.projectShelock.services.TentativaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tentativa")
public class TentativaController {

    public TentativaService tentativaService;

    public TentativaController(TentativaService tentativaService) {
        this.tentativaService = tentativaService;
    }

    @PostMapping
    public ResponseEntity<Tentativa> registrarTentativa(@RequestBody Tentativa tentativa) {
        Tentativa novaTentativa = tentativaService.registrar(
                tentativa.getUsuarioId(),
                tentativa.getCasoId(),
                tentativa.isAcertou(),
                tentativa.getTempo()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTentativa);
    }
}