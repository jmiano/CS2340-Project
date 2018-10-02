package com.cs2340.binarybros.buzztracker;

public class Admin extends User {

    private String name;
    private String username;
    private String password;
    private String email;
    private int employeeNumber;

    public Admin(String nameInput, String usernameInput, String passwordInput, String emailInput,
                 int employeeID) {
        super(nameInput, usernameInput, passwordInput, emailInput);
        this.employeeNumber = employeeID;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }
}
