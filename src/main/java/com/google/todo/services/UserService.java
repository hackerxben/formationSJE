package com.google.todo.services;

import java.util.List;

import com.google.todo.entities.User;

public interface UserService {
    public User addUser(User user);

    public List<User> getAllUsers();

    public boolean deleteUser(User user);
}
