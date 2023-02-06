package com.clockworkcode.music_recommendation_engine.service;

import com.clockworkcode.music_recommendation_engine.model.Music;
import com.clockworkcode.music_recommendation_engine.model.User;
import com.clockworkcode.music_recommendation_engine.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(User user) {
        return userRepository.save(user);
    }

    public User update(String id, User user) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        existingUser.setName(user.getName());
        existingUser.setAge(user.getAge());
        existingUser.setGender(user.getGender());
        existingUser.setListeningHistory(user.getListeningHistory());
        return userRepository.save(existingUser);
    }

    public List<Music> getListeningHistory(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return user.getListeningHistory();
    }

}
