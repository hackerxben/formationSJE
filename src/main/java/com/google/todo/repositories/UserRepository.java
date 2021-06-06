package com.google.todo.repositories;

import com.google.todo.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    User findByLogin(String login);
}
