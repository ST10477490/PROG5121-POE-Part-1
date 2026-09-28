 // Name: Moliehi Princes Nkomo
   // Student number: ST10477490
   package com.chatapp;
package com.chatapp;

import java.util.Scanner;

/**
 * Console application for Part 1: registration and login.
 */
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("===== REGISTRATION =====");
        System.out.print("Enter your first name: ");
        String firstName = input.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = input.nextLine();

        Login login = new Login(firstName, lastName);

        // Keep asking until the username is valid
        String username;
        do {
            System.out.print("Enter a username: ");
            username = input.nextLine();
            System.out.println(login.usernameMessage(username));
        } while (!login.checkUserName(username));

        // Keep asking until the password is valid
        String password;
        do {
            System.out.print("Enter a password: ");
            password = input.nextLine();
            System.out.println(login.passwordMessage(password));
        } while (!login.checkPasswordComplexity(password));

        // Keep asking until the cell number is valid
        String cellNumber;
        do {
            System.out.print("Enter your cell phone number (e.g. +27838968976): ");
            cellNumber = input.nextLine();
            System.out.println(login.cellNumberMessage(cellNumber));
        } while (!login.registerCellNumber(cellNumber));

        // Store the username and password
        System.out.println(login.registerUser(username, password));

        System.out.println();
        System.out.println("===== LOGIN =====");
        boolean loggedIn;
        do {
            System.out.print("Enter your username: ");
            String enteredUsername = input.nextLine();
            System.out.print("Enter your password: ");
            String enteredPassword = input.nextLine();

            loggedIn = login.loginUser(enteredUsername, enteredPassword);
            System.out.println(login.returnLoginStatus(loggedIn));
        } while (!loggedIn);

        input.close();
    }
}
