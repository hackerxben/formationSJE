package com.google.todo.entities;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Todo {

    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idTodo;
    @Size(min = 3, max = 15)
    private String titleTodo;
    private String descriptionTodo;
    private Instant dateTodo;

    @ManyToOne
    @NotNull
    private User user;

    @Override
    public String toString() {
        return "Todo [dateTodo=" + dateTodo + ", descriptionTodo=" + descriptionTodo + ", idTodo=" + idTodo
                + ", titleTodo=" + titleTodo + ", user=" + user + "]";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getIdTodo() {
        return idTodo;
    }
    public void setIdTodo(Long idTodo) {
        this.idTodo = idTodo;
    }
    public String getTitleTodo() {
        return titleTodo;
    }
    public void setTitleTodo(String titleTodo) {
        this.titleTodo = titleTodo;
    }
    public String getDescriptionTodo() {
        return descriptionTodo;
    }
    public void setDescriptionTodo(String descriptionTodo) {
        this.descriptionTodo = descriptionTodo;
    }
    public Instant getDateTodo() {
        return dateTodo;
    }
    public void setDateTodo(Instant dateTodo) {
        this.dateTodo = dateTodo;
    }

    

    
}
