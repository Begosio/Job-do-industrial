package com.has.etec.projectShelock.services;

import com.has.etec.projectShelock.entities.Tentativa;
import com.has.etec.projectShelock.repositories.TentativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TentativaService {

    @Autowired
    private TentativaRepository tentativaRepository;

    @Autowired
    private RankingService rankingService;


    public Tentativa registrar(Tentativa tentativa) {
        boolean jaTentou = tentativaRepository
                .existsByUsuarioIdAndCasoId(
                        tentativa.getUsuario(),
                        tentativa.getId(),
                );

        if (jaTentou) {
            throw new RuntimeException(
                    "Usuário já tentou este caso."
            );
        }

        if (tentativa.isAcertou()) {
            tentativa.setPontuacaoFinal(3);
        } else {
            tentativa.setPontuacaoFinal(0);
        }
        Tentativa salva = tentativaRepository.save(tentativa);
        rankingService.recalcularRanking();
        return salva;
    }
}