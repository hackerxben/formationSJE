package com.google.todo.controllers;

import java.util.List;
import java.util.logging.Logger;

import com.google.todo.entities.Todo;
import com.google.todo.entities.User;
import com.google.todo.services.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class TodoController {
    
    @Autowired
    TodoService todoService;

    Logger log = Logger.getLogger(TodoController.class.getName());

    @PostMapping("/addTodo")
    public ResponseEntity<Object> addTodo(@RequestBody Todo todo){
        Todo todoRes = null;
        try {
            todoRes = todoService.addTodo(todo);   
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body(todoRes);
    }

    @PostMapping("/findByUser")
    public ResponseEntity<Object> findByUser(@RequestBody User user){
        List<Todo> todoRes = null;
        try {
            log.info(user.toString());
            todoRes = todoService.findByUser(user);   
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body(todoRes);
    }

    @GetMapping("/getAllTodos")
    public ResponseEntity<List<Todo>> getAllTodos(){
        return ResponseEntity.ok().body(todoService.getAllTodos());
    }

    @GetMapping("/getTodosWithNoUser")
    public ResponseEntity<List<Todo>> getTodosWithNoUser(){
        return ResponseEntity.ok().body(todoService.findTodosWithNoUser());
    }

    @DeleteMapping("/deleteTodo/{idTodo}")
    public ResponseEntity<String> deleteTodo(@PathVariable("idTodo") Long idTodo){
        if(todoService.deleteTodo(idTodo)){
            return ResponseEntity.ok().body("Todo was deleted");
        }else{
            return ResponseEntity.badRequest().body("Todo was not deleted");
        }
    }
}
