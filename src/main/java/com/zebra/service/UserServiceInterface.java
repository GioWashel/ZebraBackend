package com.zebra.service;

import com.zebra.entity.User;

import java.util.List;

public interface UserServiceInterface {
    public User createUser(User user);
    public void deleteUser(User user);
    public User updateUserEmail(User user, String email);
    public User updateUserPassword(User user, String password);
    public Boolean userExists(User user);
    public List<User> getAllUsers();
    public User findByEmail(String email);

}
