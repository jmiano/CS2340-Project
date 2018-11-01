package com.cs2340.binarybros.buzztracker.Models;


import java.io.Serializable;

public class Manager extends User implements Serializable {

    public Manager(String type, String nameInput, String usernameInput, String passwordInput, String emailInput,
                   String employeeLocation, int employeeID) {
        super(type, nameInput, usernameInput, passwordInput, emailInput, employeeLocation, employeeID);

    }
}
