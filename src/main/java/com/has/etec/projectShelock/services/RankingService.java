package com.has.etec.projectShelock.services;

import com.has.etec.projectShelock.repositories.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankingService {
    @Autowired
    public RankingRepository rankingRepository;
    public RankingService(RankingRepository rankingRepository) {
        this.rankingRepository = rankingRepository;
    }
}