package com.has.etec.projectShelock.services;

import com.has.etec.projectShelock.entities.RespostaCaso;
import com.has.etec.projectShelock.entities.Tentativa;
import com.has.etec.projectShelock.repositories.CasoRepository;
import com.has.etec.projectShelock.repositories.RespostaCasoRepository;
import com.has.etec.projectShelock.repositories.TentativaRepository;
import com.has.etec.projectShelock.repositories.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TentativaService{

    public TentativaRepository tentativaRepository;
    public UsuarioRepository usuarioRepository;
    public CasoRepository casoRepository;
    public RespostaCasoRepository respostaCasoRepository;
    public RankingService rankingService;

    public TentativaService(
            TentativaRepository tentativaRepository,
            UsuarioRepository usuarioRepository,
            CasoRepository casoRepository,
            RespostaCasoRepository respostaCasoRepository,
            RankingService rankingService) {
        this.tentativaRepository = tentativaRepository;
        this.usuarioRepository = usuarioRepository;
        this.casoRepository = casoRepository;
        this.respostaCasoRepository = respostaCasoRepository;
        this.rankingService = rankingService;
    }

    public Tentativa registrar(Long usuarioId, Long casoId, Long respostaId, int tempo) {
        if (!usuarioRepository.existsById(usuarioId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado.");
        }

        if (!casoRepository.existsById(casoId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Caso não encontrado.");
        }

        if (tentativaRepository.findByUsuarioIdAndCasoId(usuarioId, casoId).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já possui uma tentativa para este caso.");
        }

        boolean acertou = validarResposta(casoId, respostaId);

        Tentativa tentativa = new Tentativa();
        tentativa.setUsuarioId(usuarioId);
        tentativa.setCasoId(casoId);
        tentativa.setTempo(tempo);
        tentativa.setAcertou(acertou);

        Tentativa tentativaSalva = tentativaRepository.save(tentativa);
        rankingService.atualizarRanking(tentativaSalva);

        return tentativaSalva;
    }

    public boolean validarResposta(Long casoId, Long respostaId) {
        RespostaCaso respostaCorreta = respostaCasoRepository.findByCasoIdAndCorretaTrue(casoId).orElse(null);
        return respostaCorreta != null && respostaCorreta.getId().equals(respostaId);
    }
}