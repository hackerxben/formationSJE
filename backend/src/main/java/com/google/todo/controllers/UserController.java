package com.google.todo.controllers;

import java.util.List;
import java.util.logging.Logger;

import com.google.todo.entities.User;
import com.google.todo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    Logger log = Logger.getLogger(UserController.class.getName());

    @PostMapping("/addUser")
    public ResponseEntity<Object> addUser(@RequestBody User user){
        User userRes = null;
        try {
            log.info("going to try to save a user");
            userRes = userService.addUser(user);
            System.out.println("user should be saved in database");
            if(userRes.getIdUser() == null){
                throw new Exception("User ID is null , check your logs for errors");
            }
        } catch (Exception e) {
            ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.ok().body(userRes);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<String> deleteUser(@RequestBody User user){
        if(userService.deleteUser(user)){
            return ResponseEntity.ok().body("User was deleted");
        }else{
            return ResponseEntity.badRequest().body("User was not deleted");
        }
    }
}
