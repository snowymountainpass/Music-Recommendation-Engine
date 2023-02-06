package com.clockworkcode.music_recommendation_engine.repository;

import com.clockworkcode.music_recommendation_engine.model.Music;
import com.clockworkcode.music_recommendation_engine.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);
    User findByUsername(String username);
    User findByUserId(String userId);

    List<Music> getListeningHistory(String id);
    List<User> findAll();
    User save(User user);
}

