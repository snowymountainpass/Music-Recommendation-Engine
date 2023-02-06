package com.clockworkcode.music_recommendation_engine.service;

import com.clockworkcode.music_recommendation_engine.model.Music;
import com.clockworkcode.music_recommendation_engine.model.User;
import com.clockworkcode.music_recommendation_engine.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {

    @Autowired
    private MusicRepository musicRepository;

    @Autowired
    private RecommendationRepository recommendationRepository;

    @Autowired
    private RecommendationAlgorithm recommendationAlgorithm;

    public List<Music> search(String query) {
        return musicRepository.search(query);
    }

    public Music getDetails(String id) {
        return musicRepository.findById(id).orElseThrow(() -> new MusicNotFoundException(id));
    }

    public List<Music> getRecommendations(String userId) {
        List<Music> recommendations = recommendationRepository.getRecommendations(userId);
        if (recommendations.isEmpty()) {
            User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
            recommendations = recommendationAlgorithm.generateRecommendations(user);
            recommendationRepository.saveRecommendations(userId, recommendations);
        }
        return recommendations;
    }
}
