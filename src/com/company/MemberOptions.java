package com.company;

import java.util.*;

public class MemberOptions {

    static Map<Integer, ArrayList<MemberDetails>> hm = new HashMap<>();

    public static void menu() {

        addMemberDetails();
        System.out.println("[1] Add Member");
        System.out.println("[2] Delete Member");
        System.out.println("[3] View Member details");
        System.out.println("[4] Exit");
        System.out.print("Enter: ");
        Scanner c = new Scanner(System.in);
        int choice = c.nextInt();
        do {
            switch (choice) {
                case 1:
                    addMember();
                    break;
                case 2:
                    deleteMember();
                    break;
                case 3:
                    viewMemberDetails();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid input");
                    break;
            }
            c = new Scanner(System.in);
            choice = c.nextInt();
        } while (choice > 0 && choice < 4);
    }

    private static void addMember() {

    }

    private static void deleteMember() {

    }

    private static void viewMemberDetails() {

    }

    private static void addMemberDetails() {


    }
}