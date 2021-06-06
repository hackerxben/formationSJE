package com.google.todo.services;

import java.util.List;

import com.google.todo.entities.Todo;
import com.google.todo.entities.User;

public interface TodoService {
    public Todo addTodo(Todo todo) throws Exception;
    public List<Todo> findByUser(User user);
    public List<Todo> getAllTodos();
    public Boolean deleteTodo(Long idTodo);
    public List<Todo> findTodosWithNoUser();
}
