package com.google.todo.services.impl;

import java.util.List;

import com.google.todo.entities.Todo;
import com.google.todo.entities.User;
import com.google.todo.repositories.TodoRepository;
import com.google.todo.services.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    TodoRepository todoRepoisitory;

    @Override
    public Todo addTodo(Todo todo) throws Exception{
        // Business 
        if(todo.getTitleTodo().equals("MyFirstTodo")){
            throw new Exception("The title of the todo can not be 'MyFirstTodo'");
        }
        return todoRepoisitory.save(todo);
    }

    @Override
    public List<Todo> findByUser(User user) {
        return todoRepoisitory.findByUser(user);
    }

    @Override
    public List<Todo> getAllTodos() {
        return todoRepoisitory.findAll();
    }

    @Override
    public Boolean deleteTodo(Long idTodo) {
        try {
            todoRepoisitory.deleteById(idTodo);   
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<Todo> findTodosWithNoUser() {
        return todoRepoisitory.findByUserIsNull();
    }

    
    
}
