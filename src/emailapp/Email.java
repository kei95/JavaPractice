package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "generac";

    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        // Call a method asking for the department - return the department
        this.department = setDepartment();

        // Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);

        // Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix + ".com";
    }

    // Ask for the department
    private String setDepartment() {
        System.out.print("Enter the department\n1for Sales\n2 for Development\n3 for Accounting\n0 for none");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) { return "sales"; }
        else if (depChoice == 2) { return "development"; }
        else if (depChoice == 3) { return "accounting"; }
        else { return ""; }
    }

    // Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@#$%";
        char[] password = new char[length];
        for (int i = 0; i<length; i++) {
           int rand =  (int) (Math.random() * passwordSet.length());
           password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // Set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }
    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }
    public String getAlternateEmail() {
        return alternateEmail;
    }

    // Change the password
    public void changePassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    public String showInfo() {
        return "DISPLAY_NAME: " + firstName + " " + lastName +
                "\nCOMPANY_EMAIL: " + email +
                "\nMAILBOX_CAPACITY: " + mailboxCapacity + "MB";
    }
}
