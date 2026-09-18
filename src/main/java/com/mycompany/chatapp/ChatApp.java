/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatapp;
import java.util.Scanner;
/**
 *
 * @author Student
 */
public class ChatApp {

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        Login userLogin = new Login(firstName, lastName);

        System.out.print("Enter Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        System.out.print("Enter Cell Phone Number (e.g. +27839658976): ");
        String phone = scanner.nextLine();

        String registrationStatus = userLogin.registerUser(username, password, phone);
        System.out.println(registrationStatus);

        if (registrationStatus.equals("Username successfully captured.")) {
            System.out.println("\n--- LOGIN ---");
            System.out.print("Enter Username to Login: ");
            String loginUser = scanner.nextLine();

            System.out.print("Enter Password to Login: ");
            String loginPass = scanner.nextLine();

            boolean loginSuccess = userLogin.loginUser(loginUser, loginPass);
            System.out.println(userLogin.returnLoginStatus(loginSuccess));
        }

        scanner.close();
    }
} 
        
    

