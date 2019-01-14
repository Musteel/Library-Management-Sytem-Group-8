package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class MemberOptions {

    static List<MemberDetails> members = new CopyOnWriteArrayList<>();
    static Map<Integer, ArrayList<MemberDetails>> hm = new HashMap<>();

    public static void menu() {
        int choice;

            addMemberDetails();
        do {


            System.out.println(" ");
            System.out.println("[1] Add Member");
            System.out.println("[2] Delete Member");
            System.out.println("[3] View Member details");
            System.out.println("[4] Back");
            System.out.println("----------------------");
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
        Scanner c1 = new Scanner(System.in);
        String name = c1.nextLine();

        MemberDetails member = new MemberDetails(memberId, name);
        members.add(member);
    }

    private static void viewMemberDetails() {

            for (MemberDetails member : members) {
                System.out.println(member.getMemberId() + "  " + member.getMemberName());

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
        int MemberId = c.nextInt();

        for (MemberDetails member : members) {
            if (member.getMemberId() == MemberId) {
                members.remove(member);
            }
        }
    }
}