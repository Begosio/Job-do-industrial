package com.has.etec.projectShelock.controllers;




import com.has.etec.projectShelock.dtos.caso.CasoResponse;
import com.has.etec.projectShelock.services.CasoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/casos")
public class CasoController {

    private final CasoService casoService;

    public CasoController(CasoService casoService) {
        this.casoService = casoService;
    }

    @GetMapping("/{id}")
    public CasoResponse buscarPorId(@PathVariable Long id) {
        return casoService.buscarPorId(id);
    }
}