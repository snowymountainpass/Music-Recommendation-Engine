package com.clockworkcode.music_recommendation_engine.controller;

import com.clockworkcode.music_recommendation_engine.model.Evaluation;
import com.clockworkcode.music_recommendation_engine.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluation")
public class EvaluationController {

    @Autowired
    private EvaluationService evaluationService;

    @PostMapping
    public Evaluation addEvaluation(@RequestBody Evaluation evaluation) {
        return evaluationService.addEvaluation(evaluation);
    }

    @PutMapping("/{id}")
    public Evaluation updateEvaluation(@PathVariable String id, @RequestBody Evaluation evaluation) {
        return evaluationService.updateEvaluation(id, evaluation);
    }

    @GetMapping("/{userId}")
    public List<Evaluation> getEvaluationsByUser(@PathVariable String userId) {
        return evaluationService.getEvaluationsByUser(userId);
    }
}

