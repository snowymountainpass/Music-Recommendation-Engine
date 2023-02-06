package com.clockworkcode.music_recommendation_engine.service;

import com.clockworkcode.music_recommendation_engine.model.Data_Preprocessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataPreprocessingService {

    @Autowired
    private Data_Preprocessing dataPreprocessing;

    public void preprocessData(String dataFilePath) {
        dataPreprocessing.preprocessData(dataFilePath);
    }
}

