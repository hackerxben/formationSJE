package com.google.todo.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class HelloController {
    
    @GetMapping("/hello")
    public HelloMessage helloMethod(@RequestParam("name") String name){
        System.out.println("in hello method");
        HelloMessage message = new HelloMessage();
        message.name = name;
        return message;
    }

    @RequestMapping("/hello/{name}")
    public HelloMessage helloMethod2(@PathVariable("name") String name){
        HelloMessage message = new HelloMessage();
        message.name = name;
        return message;
    }

    @PostMapping("/hello")
    public HelloMessage helloMethod3(@RequestBody String name){
        HelloMessage message = new HelloMessage();
        message.name = name;
        return message;
    }
}
