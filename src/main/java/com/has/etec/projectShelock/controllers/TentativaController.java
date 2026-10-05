package com.has.etec.projectShelock.controllers;

import com.has.etec.projectShelock.entities.Tentativa;
import com.has.etec.projectShelock.services.TentativaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tentativa")
public class TentativaController {

    @Autowired
    public TentativaServices tentativaService;


    @PostMapping
    public Tentativa registrar(
            @RequestBody Tentativa tentativa) {

        return tentativaService.;
    }
}