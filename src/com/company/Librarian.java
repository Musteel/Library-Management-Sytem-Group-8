package com.company;

import java.util.Scanner;

public class Librarian {

    public static Scanner input = new Scanner(System.in);

    public static void menu() {

        int selectionLib;
        do {
            System.out.println("[1] Book Options ");
            System.out.println("[2] Member Options ");
            System.out.println("[3] Exit ");
            System.out.println("----------------------");
            System.out.print("Enter: ");

            switch (selectionLib = input.nextInt()) {
                case 1:
                    BookOptions.menu();
                    break;
                case 2:
                    MemberOptions.menu();
                    break;
                case 3:
                    System.out.println("Thank you for using this program");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (!((selectionLib <= 0) || (selectionLib >= 3)));

    }
}
