package com.autoservice.model;

/**
 * Created by Legat on 10/29/2016.
 */
public class AuthClnt {
    Long id;
    String name;
    Boolean auth;
    String role;

    public AuthClnt() {
        this.auth = false;
    }

    public AuthClnt(Long id, String name, Boolean auth) {
        this.id = id;
        this.name = name;
        this.auth = auth;
        this.role="client";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAuth() {
        return auth;
    }

    public void setAuth(Boolean auth) {
        this.auth = auth;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
