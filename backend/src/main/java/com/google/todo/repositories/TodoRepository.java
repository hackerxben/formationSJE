package com.google.todo.repositories;

import java.util.List;

import com.google.todo.entities.Todo;
import com.google.todo.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Long>{
    List<Todo> findByUser(User user);
    List<Todo> findByUserIsNull();
}
