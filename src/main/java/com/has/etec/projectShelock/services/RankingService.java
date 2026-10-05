package com.has.etec.projectShelock.services;

import com.has.etec.projectShelock.repositories.RankingRepository;
import org.springframework.stereotype.Service;

@Service
public class RankingService {

    public RankingRepository rankingRepository;
    public RankingService(RankingRepository rankingRepository) {
        this.rankingRepository = rankingRepository;
    }
}