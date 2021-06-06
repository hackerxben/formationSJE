package com.google.todo.services.impl;

import java.util.List;

import com.google.todo.entities.User;
import com.google.todo.repositories.UserRepository;
import com.google.todo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImple implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean deleteUser(User user) {
        try {
            userRepository.delete(user);    
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }        
        return true;
    }
    
}
