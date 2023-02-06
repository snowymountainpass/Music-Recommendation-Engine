package com.clockworkcode.music_recommendation_engine.controller;

import com.clockworkcode.music_recommendation_engine.service.DataPreprocessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data-preprocessing")
public class DataPreprocessingController {

    @Autowired
    private DataPreprocessingService dataPreprocessingService;

    @PostMapping("/process")
    public void processData(@RequestParam String dataFilePath) {
        dataPreprocessingService.preprocessData(dataFilePath);
    }
}

