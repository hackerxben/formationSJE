package com.google.todo.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idUser;
    private String login;
    private String password;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Todo> todos;

    @Override
    public String toString() {
        return "User [firstName=" + firstName + ", idUser=" + idUser + ", lastName=" + lastName + ", login=" + login
                + ", password=" + password + "]";
    }

    public Long getIdUser() {
        return idUser;
    }
    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
}
