package com.clockworkcode.music_recommendation_engine.controller;

import com.clockworkcode.music_recommendation_engine.model.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @GetMapping("/{id}")
    public List<Music> getRecommendations(@PathVariable String id) {
        return recommendationService.getRecommendations(id);
    }

    @PutMapping("/{id}")
    public void updateRecommendations(@PathVariable String id, @RequestBody List<Music> musicList) {
        recommendationService.updateRecommendations(id, musicList);
    }

}
