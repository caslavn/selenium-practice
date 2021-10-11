package com.example.seleniumpractice.dto;

import com.example.seleniumpractice.model.Client;

import java.io.Serializable;

public class ClientDTO implements Serializable {

    private String username;
    private String password;

    public ClientDTO(Client client) {
        this.username = client.getUsername();
        this.password = client.getPassword();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
