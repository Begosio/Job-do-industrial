package com.has.etec.projectShelock.services;

import com.has.etec.projectShelock.entities.Tentativa;
import com.has.etec.projectShelock.repositories.RankingRepository;
import com.has.etec.projectShelock.repositories.TentativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankingService {
    @Autowired
    public RankingRepository rankingRepository;
    @Autowired
    public TentativaRepository tentativaRepository;

    public RankingService(RankingRepository rankingRepository) {
        this.rankingRepository = rankingRepository;
    }


    public void recalcularRanking() {
        List<Tentativa> tentativas = tentativaRepository.findAllByOrderByTempoAsc();
        int posicao = 1;


        for (Tentativa tentativa : tentativas) {
            int multiplicador = getMultiplicador(posicao);

            int pontuacaoFinal = tentativa.getPontuacaoFinal() * multiplicador;

            posicao++;
        }
    }


    private int getMultiplicador(int posicao) {

        switch (posicao) {

            case 1:
                return 25;

            case 2:
                return 18;

            case 3:
                return 15;

            case 4:
                return 12;

            case 5:
                return 10;

            case 6:
                return 8;

            case 7:
                return 6;

            case 8:
                return 4;

            case 9:
                return 2;

            case 10:
                return 1;

            default:
                return 1;

        }
    }
}