package com.cs2340.binarybros.buzztracker.Models;


/**
 * This class is for the admin
 */
public class Admin extends User{
    /**
     * the constructor of admin
     * @param type the type
     * @param nameInput the name
     * @param usernameInput the username
     * @param passwordInput the password
     * @param emailInput the email
     * @param employeeLocation the employee
     * @param employeeID the ID of the employee
     */
    public Admin(String type, String nameInput, String usernameInput, String passwordInput,
                 String emailInput, String employeeLocation, int employeeID) {
        super(type, nameInput, usernameInput, passwordInput, emailInput, employeeLocation,
                employeeID);
    }

}
