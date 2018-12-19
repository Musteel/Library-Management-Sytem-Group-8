package com.company;

import java.util.*;

public class MemberOptions {

    static List<MemberDetails> members = new ArrayList<>();
    static Map<Integer, ArrayList<MemberDetails>> hm = new HashMap<>();

    public static void menu() {
        int choice;
        do {

            addMemberDetails();
            System.out.println(" ");
            System.out.println("[1] Add Member");
            System.out.println("[2] Delete Member");
            System.out.println("[3] View Member details");
            System.out.println("[4] Back");
            System.out.println("Enter: ");
            Scanner c = new Scanner(System.in);
            choice = c.nextInt();

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
                    Librarian.menu();
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }

        } while (choice > 0 && choice < 4);
    }

    private static void addMember() {
        System.out.println("Enter Member Id");
        Scanner c = new Scanner(System.in);
        int memberId = c.nextInt();
        System.out.println("Enter Name");
        String name = c.nextLine();

        MemberDetails member = new MemberDetails(memberId, name);
        members.add(member);
    }

    private static void viewMemberDetails() {
        for (MemberDetails b : members) {
            System.out.print(b.getMemberId() + "  " + b.getMemberName() );
        }
    }

    private static void addMemberDetails() {
        MemberDetails md1 = new MemberDetails(12, "Kim");
        MemberDetails md2 = new MemberDetails(24, "John");
        MemberDetails md3 = new MemberDetails(36, "Patrick");
        MemberDetails md4 = new MemberDetails(48, "Helen");
        ArrayList<MemberDetails> list1 = new ArrayList<>();
        ArrayList<MemberDetails> list2 = new ArrayList<>();
        ArrayList<MemberDetails> list3 = new ArrayList<>();
        ArrayList<MemberDetails> list4 = new ArrayList<>();

        list1.add(md1);
        list2.add(md2);
        list3.add(md3);
        list4.add(md4);
        hm.put(1, list1);
        hm.put(11, list2);
        hm.put(13, list3);
        hm.put(14, list4);

    }

    private static void deleteMember() {
        System.out.println("Enter Member Id");
        Scanner c = new Scanner(System.in);
        int bookNumber = c.nextInt();

        for (MemberDetails b : members) {
            if (b.getMemberId() == bookNumber) {
                members.remove(b);
            }
        }
    }
}