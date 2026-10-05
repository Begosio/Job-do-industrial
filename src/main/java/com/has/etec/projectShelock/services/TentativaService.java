package com.has.etec.projectShelock.services;

import com.has.etec.projectShelock.dtos.tentativa.TentativaRequest;
import com.has.etec.projectShelock.dtos.usuario.UsuarioRequest;
import com.has.etec.projectShelock.entities.Tentativa;
import com.has.etec.projectShelock.entities.Usuario;
import com.has.etec.projectShelock.repositories.TentativaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TentativaService {

    public TentativaRepository tentativaRepository;

    public TentativaService(TentativaRepository tentativaRepository) {
        this.tentativaRepository = tentativaRepository;
    }


    public Tentativa salvarTentativa(TentativaRequest request) {


        Tentativa tentativa  = new Tentativa();
        return tentativaRepository.save(tentativa);
    }
}
