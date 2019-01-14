package com.company;

import java.util.*;

import static com.company.BookOptions.issueBook;
import static com.company.BookOptions.viewBookDetails;

public class Member {

    public static Scanner input = new Scanner(System.in);

    public static void menu() {

        int selectionMem;
        do {
            System.out.println(" ");
            System.out.println("[1] View Books");
            System.out.println("[2] Request Book");
            System.out.println("[3] Exit");
            System.out.println("----------------------");
            System.out.println("Enter: ");

            switch (selectionMem = input.nextInt()) {
                case 1:
                    viewBookDetails();
                    break;
                case 2:
                    issueBook();
                    break;
                case 3:
                    System.out.println("Thank you for using this program");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }

        } while (!((selectionMem <= 0) || (selectionMem >= 5)));
    }

}

