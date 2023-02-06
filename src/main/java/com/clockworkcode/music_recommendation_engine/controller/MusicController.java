package com.clockworkcode.music_recommendation_engine.controller;

import com.clockworkcode.music_recommendation_engine.model.Music;
import com.clockworkcode.music_recommendation_engine.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private MusicService musicService;

    @GetMapping("/search")
    public List<Music> search(@RequestParam("query") String query) {
        return musicService.search(query);
    }

    @GetMapping("/{id}")
    public Music getDetails(@PathVariable String id) {
        return musicService.getDetails(id);
    }

    @GetMapping("/{id}/recommendations")
    public List<Music> getRecommendations(@PathVariable String id) {
        return musicService.getRecommendations(id);
    }

}
