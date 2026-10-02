package com.has.etec.projectShelock.controllers;


import com.has.etec.projectShelock.entities.Usuario;
import com.has.etec.projectShelock.services.UsuarioService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario) {

        System.out.println("CHEGOU NO CONTROLLER");
        System.out.println("Nome: " + usuario.getNome());

        Usuario salvo = usuarioService.save(usuario);

        System.out.println("ID GERADO: " + salvo.getId());

        return salvo;
    }
}