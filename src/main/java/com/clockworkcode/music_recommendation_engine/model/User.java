package com.clockworkcode.music_recommendation_engine.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import org.hibernate.annotations.CascadeType;

import java.util.List;

@Entity
public class User {

    @Id
    private String userId;

    private String name;

    private int age;

//    private Gender gender;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Music> listeningHistory;

    // constructor, getters, and setters


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Music> getListeningHistory() {
        return listeningHistory;
    }

    public void setListeningHistory(List<Music> listeningHistory) {
        this.listeningHistory = listeningHistory;
    }
}
