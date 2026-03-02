package com.adorno.model;
public class LoginRequest {
    private String username;
    private String password;

    // Constructor vacío (necesario para Jackson)
    public LoginRequest() {}

    // Constructor para facilitar los tests
    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters y Setters (imprescindibles)
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}