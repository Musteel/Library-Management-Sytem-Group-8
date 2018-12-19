package com.company;

import java.util.Scanner;

public class Login {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("-----Library Management System-----");
        System.out.println("-----------------------------------");
        System.out.println("Choose your occupation");

        int selection;
        do {
            System.out.println(" ");
            System.out.println("[1] Librarian ");
            System.out.println("[2] Member ");
            System.out.println("[3] Exit ");
            System.out.println("----------------------");
            System.out.print("Enter: ");

            switch (selection = input.nextInt()) {
                case 1:
                    Librarian.menu();
                    break;
                case 2:
                    Member.menu();
                    break;
                case 3:
                    System.out.println("Thank you for using this program");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (selection != 3);
    }
}