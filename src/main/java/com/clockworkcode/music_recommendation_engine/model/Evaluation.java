package com.clockworkcode.music_recommendation_engine.model;

import jakarta.persistence.Entity;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Entity
public class Evaluation {

    @Id
    private String id;
    private String userId;
    private String musicId;
    private int rating;
    private LocalDateTime timestamp;

    // constructor, getters, and setters
}
