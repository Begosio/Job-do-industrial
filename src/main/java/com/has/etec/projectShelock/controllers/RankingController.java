package com.has.etec.projectShelock.controllers;

import com.has.etec.projectShelock.entities.Ranking;
import com.has.etec.projectShelock.services.RankingService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Ranking>> buscarRanking() {
        List<Ranking> ranking = rankingService.buscarRanking();
        return ResponseEntity.ok(ranking);
    }
}