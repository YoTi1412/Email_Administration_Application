package org.yoti;

import java.security.SecureRandom;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EmailApp {
    private String firstName;
    private String lastName;
    private String password;
    private int defaultPasswordLength = 12;
    private String department;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String company = "company.com";
    private String email;

    public EmailApp(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("EMAIL CREATED : " + this.firstName + " " + this.lastName);

        this.department = setDepartment();

        this.password = generatePassword(defaultPasswordLength);
        System.out.println("Your password is : " + this.password);

        setEmail();
    }

    // Method to set department
    private String setDepartment() {
        showDepartment();
        Scanner scanner = new Scanner(System.in);
        try {
            int department = scanner.nextInt();
            if (department == 1) {
                return "sales";
            } else if (department == 2) {
                return "development";
            } else if (department == 3) {
                return "accounting";
            } else if (department == 0) {
                return "None";
            } else {
                throw new InputMismatchException("Invalid department choice");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid department number.");
            return setDepartment(); // Recursively call setDepartment() until a valid input is received
        }
    }

    // Method to generate random password
    private String generatePassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);
        // Generating random password characters
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(passwordSet.length());
            char randomChar = passwordSet.charAt(randomIndex);
            password.append(randomChar);
        }
        return password.toString();
    }

    // Method to set email
    private void setEmail() {
        this.email = this.firstName + "." + this.lastName + "@" + this.department + "." + this.company;
    }

    // Method to display department options
    private void showDepartment() {
        System.out.println("new Worker " + this.firstName + " choose a Department : ");
        System.out.println("1 - sales");
        System.out.println("2 - development");
        System.out.println("3 - accounting");
        System.out.println("0 - none");
        System.out.println("Select a department : ");
    }

    // Setter methods
    public void setPassword(String password) {
        this.password = password;
    }

    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    // Getter methods
    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getPassword() {
        return password;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    // Method to display information
    public void showInfo() {
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Company Email: " + email);
        System.out.println("Mailbox Capacity: " + mailboxCapacity);
    }
}
