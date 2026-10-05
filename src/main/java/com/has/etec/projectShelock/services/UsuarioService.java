package com.has.etec.projectShelock.services;

import com.has.etec.projectShelock.entities.Usuario;
import com.has.etec.projectShelock.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    public  UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario cadastrarNovoUsuario(Usuario usuario) {
        if (usuario.getNome() == null || usuario.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do usuário deve estar preenchido!");
        }

        Optional<Usuario> usuarioExistente = usuarioRepository.findByNome(usuario.getNome());
        if (usuarioExistente.isPresent()) {
            throw new RuntimeException("Já existe um usuário cadastrado com este nome!");
        }

        return usuarioRepository.save(usuario);
    }
}