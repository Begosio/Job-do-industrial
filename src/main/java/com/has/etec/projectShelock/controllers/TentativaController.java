package com.has.etec.projectShelock.controllers;


import com.has.etec.projectShelock.entities.Tentativa;
import com.has.etec.projectShelock.services.TentativaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/tentativa")
public class TentativaController {


    public final TentativaService tentativaService;

    public TentativaController(TentativaService tentativaService) {
        this.tentativaService = tentativaService;
    }

    @PostMapping
    public Tentativa enviarTentativa(@RequestBody Tentativa tentativa){
       return tentativaService.salvarTentativa(tentativa);
    }
}
