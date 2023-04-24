package com.example.project_ogini.model.entities;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;

    public LoginRequest() {
        super();
    }

    public LoginRequest(String userName, String password) {
        super();
        this.username = userName;
        this.password = password;
    }

}
