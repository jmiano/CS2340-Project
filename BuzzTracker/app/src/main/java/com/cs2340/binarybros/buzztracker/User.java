package com.cs2340.binarybros.buzztracker;

public class User {

    private String name;
    private String username;
    private String password;
    private String email;

    public User(String nameInput, String usernameInput, String passwordInput, String emailInput) {
        name = nameInput;
        username = usernameInput;
        password = passwordInput;
        email = emailInput;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
