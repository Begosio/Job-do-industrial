package com.has.etec.projectShelock.services;

import com.has.etec.projectShelock.entities.Ranking;
import com.has.etec.projectShelock.entities.Tentativa;
import com.has.etec.projectShelock.repositories.RankingRepository;
import com.has.etec.projectShelock.repositories.TentativaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankingService {

    public RankingRepository rankingRepository;
    public TentativaRepository tentativaRepository;

    public RankingService(RankingRepository rankingRepository, TentativaRepository tentativaRepository) {
        this.rankingRepository = rankingRepository;
        this.tentativaRepository = tentativaRepository;
    }

    public List<Ranking> buscarRanking() {
        return rankingRepository.findTop10ByOrderByPosicaoAsc();
    }

    public Ranking atualizarRanking(Tentativa tentativa) {
        rankingRepository.deleteAll();

        List<Tentativa> tentativasOrdenadas = tentativaRepository.findAllByOrderByTempoAsc();
        Ranking rankingDaTentativaAtual = null;

        for (int i = 0; i < tentativasOrdenadas.size(); i++) {
            Tentativa t = tentativasOrdenadas.get(i);
            int posicao = i + 1;

            int pontuacaoBase = t.calcularPontuacaoBase();
            int multiplicador = definirMultiplicador(posicao);
            int bonus = 0;

            if (t.getId().equals(tentativa.getId())) {
                bonus = bonusRecorde(posicao);
            }

            int pontuacaoFinal = (pontuacaoBase * multiplicador) + bonus;
            t.setPontuacaoFinal(pontuacaoFinal);

            Ranking ranking = new Ranking();
            ranking.setTentativaId(t.getId());
            ranking.setPosicao(posicao);
            ranking.setTempo(t.getTempo());
            ranking.setPontuacaoFinal(pontuacaoFinal);

            Ranking rankingSalvo = rankingRepository.save(ranking);

            if (t.getId().equals(tentativa.getId())) {
                rankingDaTentativaAtual = rankingSalvo;
            }
        }

        return rankingDaTentativaAtual;
    }

    public int definirMultiplicador(int posicao) {
        return switch (posicao) {
            case 1 -> 25;
            case 2 -> 18;
            case 3 -> 15;
            case 4 -> 12;
            case 5 -> 10;
            case 6 -> 8;
            case 7 -> 6;
            case 8 -> 4;
            case 9 -> 2;
            case 10 -> 1;
            default -> 0;
        };
    }

    public int bonusRecorde(int posicao) {
        return switch (posicao) {
            case 1 -> 25;
            case 2 -> 18;
            case 3 -> 15;
            case 4 -> 12;
            case 5 -> 10;
            case 6 -> 8;
            case 7 -> 6;
            case 8 -> 4;
            case 9 -> 2;
            case 10 -> 1;
            default -> 0;
        };
    }
}