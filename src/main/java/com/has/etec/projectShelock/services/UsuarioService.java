package com.has.etec.projectShelock.services;

import com.has.etec.projectShelock.entities.Usuario;
import com.has.etec.projectShelock.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    public  UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }


}
