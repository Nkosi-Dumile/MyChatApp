/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;

/**
 *
 * @author Student
 */
public class Login {
private String username;
private String password;
private String phoneNumber;
private String firstName;
private String lastName;

public Login() {}
public Login(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public boolean checkUserName(String username) {
        return username != null && username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        boolean hasCapital = !password.equals(password.toLowerCase());
        boolean hasDigit = password.matches(".\\d.");
        boolean hasSpecial = password.matches(".[!@#$%^&()_+\\-=\\[\\]{};':\"\\\\|,.<>/?].*");

        return hasCapital && hasDigit && hasSpecial;
    }

    public boolean checkCellPhoneNumber(String phoneNumber) {
        return phoneNumber != null && phoneNumber.matches("^\\+\\d{1,3}\\d{1,10}$");
    }

    public String registerUser(String username, String password, String phoneNumber) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber(phoneNumber)) {
            return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        }

        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        return "Username successfully captured.";
    }

    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return enteredUsername != null && enteredPassword != null
                && enteredUsername.equals(this.username)
                && enteredPassword.equals(this.password);
    }

    public String returnLoginStatus(boolean isLoggedIn) {
        if (isLoggedIn) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}



