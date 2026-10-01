package com.has.etec.projectShelock.controllers;

import com.has.etec.projectShelock.entities.Resultado;
import com.has.etec.projectShelock.entities.Usuario;
import com.has.etec.projectShelock.repositories.UsuarioRepository;
import com.has.etec.projectShelock.services.UsuarioService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    public UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario){return null;}

    @GetMapping("/{id}")
    public ResponseEntity<Resultado> mostrarResultados(){return null;}
}
