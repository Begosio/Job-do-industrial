package com.has.etec.projectShelock.controllers;

import com.has.etec.projectShelock.services.SuspeitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/suspeito")
public class SuspeitoController {

    @Autowired
    public SuspeitoService suspeitoService;

    public SuspeitoController(SuspeitoService suspeitoService) {
        this.suspeitoService = suspeitoService;
    }
}
