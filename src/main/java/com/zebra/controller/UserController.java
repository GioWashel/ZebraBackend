package com.zebra.controller;


import com.zebra.entity.User;
import com.zebra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/signup")
    User newUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }
    @GetMapping("/login")
    User getUser(@RequestBody User getUser)   {
        return userRepository.getReferenceById(getUser.getId());
    }
}
