package com.has.etec.projectShelock.services;

import com.has.etec.projectShelock.entities.Tentativa;
import com.has.etec.projectShelock.repositories.CasoRepository;
import com.has.etec.projectShelock.repositories.TentativaRepository;
import com.has.etec.projectShelock.repositories.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TentativaService {

    public TentativaRepository tentativaRepository;
    public UsuarioRepository usuarioRepository;
    public CasoRepository casoRepository;
    public RankingService rankingService;

    public TentativaService(
            TentativaRepository tentativaRepository,
            UsuarioRepository usuarioRepository,
            CasoRepository casoRepository,
            RankingService rankingService) {
        this.tentativaRepository = tentativaRepository;
        this.usuarioRepository = usuarioRepository;
        this.casoRepository = casoRepository;
        this.rankingService = rankingService;
    }

    public Tentativa registrar(Long usuarioId, Long casoId, boolean acertou, int tempo) {
        if (!usuarioRepository.existsById(usuarioId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado.");
        }

        if (!casoRepository.existsById(casoId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Caso não encontrado.");
        }

        if (tentativaRepository.findByUsuarioIdAndCasoId(usuarioId, casoId).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já possui uma tentativa para este caso.");
        }

        Tentativa tentativa = new Tentativa();
        tentativa.setUsuarioId(usuarioId);
        tentativa.setCasoId(casoId);
        tentativa.setTempo(tempo);
        tentativa.setAcertou(acertou); // Recebe direto do Front-end

        Tentativa tentativaSalva = tentativaRepository.save(tentativa);
        rankingService.atualizarRanking(tentativaSalva);

        return tentativaSalva;
    }
}