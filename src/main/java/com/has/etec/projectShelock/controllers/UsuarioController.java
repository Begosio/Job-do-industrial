package com.has.etec.projectShelock.controllers;

import com.has.etec.projectShelock.entities.Usuario;
import com.has.etec.projectShelock.services.UsuarioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    public UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public Usuario cadastrarUsuario(@RequestParam String nomeUsuario) {
        return usuarioService.cadastrarUsuario(nomeUsuario);
    }
}