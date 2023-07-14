package com.zebra.controller;


import com.zebra.entity.User;
import com.zebra.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin
public class UserController {

    private UserService userService;
    //dependency injection
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //when user submits form for creating a profile, create a user.
    @PostMapping("/signup")
    ResponseEntity<User> newUser(@RequestBody User user) {
        if(userService.userExists(user)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        User freshUser = userService.createUser(user);
        return new ResponseEntity<User>(freshUser, HttpStatus.CREATED);
    }
    //when user wants to login, get user
    @GetMapping("/login")
    ResponseEntity<User> getUser(@RequestBody User user) {

        //check if user exists
        if (userService.userExists(user)) {
            User foundUser = userService.getUser(user);
            return new ResponseEntity<User>(foundUser, HttpStatus.CREATED);

            //if passwords don't match, don't give user, else send user
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
