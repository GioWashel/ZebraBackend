package com.zebra.controller;


import com.zebra.entity.User;
import com.zebra.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/")
public class UserController {

    private UserService userService;
    //dependency injection
    @Autowired

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //when user submits form for creating a profile, create a user.
    @PostMapping("/signup")
    ResponseEntity<User> registerUser(@RequestBody User user) {
        if(userService.userExists(user)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        User freshUser = userService.createUser(user);
        return new ResponseEntity<User>(freshUser, HttpStatus.CREATED);
    }
    @GetMapping("/login")
    ResponseEntity<User> fetchUser(@RequestBody User user) {
        if(userService.userExists(user)) {
            return new ResponseEntity<>(userService.getUser(user), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
    @GetMapping("users")
    List<User> fetchAllUsers() {
        return userService.getAllUsers();
    }

}
