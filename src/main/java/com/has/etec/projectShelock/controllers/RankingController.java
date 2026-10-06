package com.has.etec.projectShelock.controllers;

import com.has.etec.projectShelock.entities.Ranking;
import com.has.etec.projectShelock.services.RankingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ranking")
public class RankingController {

    public RankingService rankingService;

    public RankingController(RankingService rankingService) {
        this.rankingService = rankingService;
    }

    @GetMapping
    public List<Ranking> buscarRanking() {
        return rankingService.buscarRanking();
    }
}