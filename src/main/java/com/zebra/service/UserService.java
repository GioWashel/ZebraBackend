package com.zebra.service;

import com.zebra.entity.User;
import com.zebra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserServiceInterface {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
    public User getUser(User user) {
        return userRepository.getReferenceById(user.getId());
    }
    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public User updateUserEmail(User user, String email) {
        user.setEmail(email);
        return userRepository.save(user);
    }

    @Override
    public User updateUserPassword(User user, String password) {
        user.setPassword(password);
        return userRepository.save(user);
    }
    @Override
    public Boolean userExists(User user) {
        //get the user, if email is null, no user exists, else user exists.
        return !userRepository.findByEmail(user.getEmail()).isEmpty();
    }
}
