package com.google.todo.controllers;

import com.google.todo.config.JwtUtil;
import com.google.todo.entities.AuthRequest;
import com.google.todo.entities.AuthResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/authenticate")
    public ResponseEntity<Object> login(@RequestBody AuthRequest authRequest) throws Exception {        
        AuthResponse authResponse = new AuthResponse();
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getLogin(), authRequest.getPassword()));
            authResponse.setToken(jwtUtil.generateToken(authRequest.getLogin()));
        } catch (Exception e) {
            ResponseEntity.badRequest().body(e.getMessage());
            e.printStackTrace();
        }
        return ResponseEntity.ok().body(authResponse);
    }
}
