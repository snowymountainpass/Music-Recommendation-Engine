package com.clockworkcode.music_recommendation_engine.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import org.hibernate.annotations.CascadeType;

import java.util.List;

@Entity
public class Recommendation {

    @Id
    private String id;
    private String userId;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Music> recommendations;

    // constructor, getters, and setters


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Music> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(List<Music> recommendations) {
        this.recommendations = recommendations;
    }
}
