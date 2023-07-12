package com.zebra.controller;


import com.zebra.entity.User;
import com.zebra.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UserController {

    private UserService userService;
    //dependency injection
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //when user submits form for creating a profile, create a user.
    @PostMapping
    String newUser(@RequestBody User user) {
        if(userService.userExists(user)) {
            return "error, user already exists, try logging in?";
        }
        else {
            User freshUser = userService.createUser(user);
            return "user created";
        }

    }
    //when user wants to login, get user
    @GetMapping
    String getUser(@RequestBody User user)   {

        //check if user exists
        if(userService.userExists(user)) {
            User foundUser = userService.getUser(user);
            //if passwords don't match, don't give user, else send user
            if(!foundUser.getPassword().equals(user.getPassword())) {
                return "incorrect password :/";
            }
            return "user found!";
        }
        return "user not found!";
    }
}
