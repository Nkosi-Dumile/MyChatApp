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
            
            //PART 2: MAIN MENU 
            
            if (loginSuccess) {
                System.out.println("\nWelcome to QuickChat");
                System.out.println("--------------------");

                boolean running = true;

                while (running) {
                    System.out.println("\nPlease choose an option:");
                    System.out.println("1. Send Messages");
                    System.out.println("2. Show Report");
                    System.out.println("3. Quit");
                    System.out.print("Enter choice: ");

                    int choice = 0;
                    if (scanner.hasNextInt()) {
                        choice = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                    } else {
                        System.out.println("Invalid input. Please enter a number.");
                        scanner.nextLine(); // clear invalid input
                        continue;
                    }

                    switch (choice) {
                        case 1:
                            System.out.println("Preparing message sender...");
                            break;
                        case 2:
                            System.out.println("Coming Soon");
                            break;
                        case 3:
                            System.out.println("Exiting application. Goodbye!");
                            running = false;
                            break;
                        default:
                            System.out.println("Invalid option. Please choose 1, 2, or 3.");
                    }
                }
            }
        }
        }
    }



       

    

    

        
    

