package com.autoservice.model;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;

/**
 * Created by Legat on 11/2/2016.
 */
@Entity
public class UserAuth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String email;
    @Column
    String password;
    @Column
    String role;

    public UserAuth() {
    }

    public UserAuth(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
