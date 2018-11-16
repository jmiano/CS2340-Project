package com.cs2340.binarybros.buzztracker.Models;



public class Admin extends User{

    public Admin(String type, String nameInput, String usernameInput, String passwordInput,
                 String emailInput, String employeeLocation, int employeeID) {
        super(type, nameInput, usernameInput, passwordInput, emailInput, employeeLocation,
                employeeID);
    }

}
