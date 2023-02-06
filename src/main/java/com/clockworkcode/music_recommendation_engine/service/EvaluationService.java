package com.clockworkcode.music_recommendation_engine.service;

import com.clockworkcode.music_recommendation_engine.model.Evaluation;
import com.clockworkcode.music_recommendation_engine.repository.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationService {

    @Autowired
    private EvaluationRepository evaluationRepository;

    public Evaluation addEvaluation(Evaluation evaluation) {
        return evaluationRepository.save(evaluation);
    }

    public Evaluation updateEvaluation(String id, Evaluation evaluation) {
        Evaluation existingEvaluation = evaluationRepository.findById(id).orElseThrow(() -> new EvaluationNotFoundException(id));
        existingEvaluation.setRating(evaluation.getRating());
        existingEvaluation.setTimestamp(evaluation.getTimestamp());
        return evaluationRepository.save(existingEvaluation);
    }

    public List<Evaluation> getEvaluationsByUser(String userId) {
        return evaluationRepository.findByUserId(userId);
    }
}

