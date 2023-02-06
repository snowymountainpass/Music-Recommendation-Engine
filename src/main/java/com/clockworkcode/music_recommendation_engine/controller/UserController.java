package com.clockworkcode.music_recommendation_engine.controller;

import com.clockworkcode.music_recommendation_engine.model.Music;
import com.clockworkcode.music_recommendation_engine.model.User;
import com.clockworkcode.music_recommendation_engine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable String id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @GetMapping("/{id}/history")
    public List<Music> getListeningHistory(@PathVariable String id) {
        return userService.getListeningHistory(id);
    }

}
