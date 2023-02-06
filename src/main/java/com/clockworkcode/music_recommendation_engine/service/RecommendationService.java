package com.clockworkcode.music_recommendation_engine.service;

@Service
public class RecommendationService {

    @Autowired
    private RecommendationRepository recommendationRepository;

    @Autowired
    private RecommendationAlgorithm recommendationAlgorithm;

    public List<Music> getRecommendations(String userId) {
        List<Music> recommendations = recommendationRepository.getRecommendations(userId);
        if (recommendations.isEmpty()) {
            User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
            recommendations = recommendationAlgorithm.generateRecommendations(user);
            recommendationRepository.saveRecommendations(userId, recommendations);
        }
        return recommendations;
    }

    public void updateRecommendations(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        List<Music> newRecommendations = recommendationAlgorithm.generateRecommendations(user);
        recommendationRepository.updateRecommendations(userId, newRecommendations);
    }
}

