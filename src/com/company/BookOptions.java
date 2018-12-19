package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class BookOptions {

    static List<BookDetails> books = new ArrayList<>();
    static Map<Integer, ArrayList<BookIssueDetails>> hm = new HashMap<>();


    public static void menu() {
        int choice;
        do {

            addIssueDetails();
            System.out.println(" ");
            System.out.println("[1] Add Book");
            System.out.println("[2] Delete Book");
            System.out.println("[3] Issue a Book");
            System.out.println("[4] Return a Book");
            System.out.println("[5] View Book details");
            System.out.println("[6] View Complete Issued Book details");
            System.out.println("[7] Back");
            System.out.println("----------------------");
            System.out.println("Enter: ");

            Scanner c = new Scanner(System.in);

            switch (choice = c.nextInt()) {
                case 1:
                    addBook();
                    break;
                case 2:
                    deleteBook();
                    break;
                case 3:
                    issueBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    viewBookDetails();
                    break;
                case 6:
                    viewCompleteIssueDetails();
                    break;
                case 7:
                    Librarian.menu();
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }

        } while (choice > 0 && choice < 7);
    }

    private static void viewCompleteIssueDetails() {
        for (Map.Entry<Integer, ArrayList<BookIssueDetails>> entry : hm
                .entrySet()) {

            for (BookIssueDetails b : entry.getValue()) {
                System.out.println(entry.getKey() + "  " + b.getBookNumber()
                        + "  " + b.getName() + "  " + b.getNoOfBookIssued()
                        + "  " + b.getIssueDate() + "  " + b.getReturnDate());
            }
        }
    }

    private static void viewBookDetails() {
        for (BookDetails b : books) {
            System.out.println(b.getBookNumber() + "  " + b.getBookName() + "  "
                    + b.getCount() + "  " + b.getPrice());
        }
    }

    private static void returnBook() {
        System.out.println("Enter Member Id");
        Scanner c = new Scanner(System.in);
        int id = c.nextInt();
        System.out.println("Enter Book Id");
        int bookNumber = c.nextInt();
        List<BookIssueDetails> bd = hm.get(id);
        for (BookIssueDetails b : bd) {
            if (b.getBookNumber() == bookNumber) {
                Date issueDate = b.getIssueDate();
                Date todayDate = new Date();

                long diff = todayDate.getTime() - issueDate.getTime();

                long diffDays = diff / (24 * 60 * 60 * 1000);

                if (diffDays > 10) {
                    int fine = (int) (diffDays - 10);
                    fine = fine * 5;
                    System.out.println("Total Fine " + fine + " Sek.");
                }
            }
        }

    }

    private static void addIssueDetails() {
        BookIssueDetails bd1 = new BookIssueDetails(1, "abc", 1, new Date("04/04/2015"));
        BookIssueDetails bd2 = new BookIssueDetails(2, "xyz", 1, new Date("04/06/2017"));
        BookIssueDetails bd3 = new BookIssueDetails(3, "mn", 1, new Date());
        BookIssueDetails bd4 = new BookIssueDetails(4, "u", 1, new Date());
        ArrayList<BookIssueDetails> list1 = new ArrayList<>();
        ArrayList<BookIssueDetails> list2 = new ArrayList<>();
        ArrayList<BookIssueDetails> list3 = new ArrayList<>();
        ArrayList<BookIssueDetails> list4 = new ArrayList<>();

        list1.add(bd1);
        list2.add(bd2);
        list3.add(bd3);
        list4.add(bd4);
        hm.put(100, list1);
        hm.put(101, list2);
        hm.put(103, list3);
        hm.put(104, list4);

    }

    private static void issueBook() {
        System.out.println("Enter Member Id");
        Scanner c = new Scanner(System.in);
        int memberId = c.nextInt();
        System.out.println("Enter Book Number");
        Scanner c1 = new Scanner(System.in);
        int bookNumber = c1.nextInt();
        System.out.println("Enter Name");
        Scanner c2 = new Scanner(System.in);
        String name = c2.nextLine();
        System.out.println("Enter Date");
        Scanner c3 = new Scanner(System.in);
        String issueDate = c3.nextLine();
        BookIssueDetails newIssuedBook = new BookIssueDetails();
        newIssuedBook.setName(name);
        newIssuedBook.setBookNumber(bookNumber);

        ArrayList<BookIssueDetails> l = new ArrayList<>();


        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        try {

            Date date = formatter.parse(issueDate);
            newIssuedBook.setIssueDate(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }


        List<BookIssueDetails> list = hm.get(memberId);
        for (BookIssueDetails b : list) {
            int value = b.getNoOfBookIssued();
            newIssuedBook.setNoOfBookIssued(++value);
            l.add(newIssuedBook);
            if (value > 2)
                System.out.println("You already issued max(2) books");
            else
                hm.put(memberId, l);
        }
    }

    private static void addBook() {
        System.out.println("Enter Book Number");
        Scanner c1 = new Scanner(System.in);
        int bookNumber = c1.nextInt();
        System.out.println("Enter Name");
        Scanner c2 = new Scanner(System.in);
        String name = c2.nextLine();
        System.out.println("Enter Count");
        Scanner c3 = new Scanner(System.in);
        int count = c3.nextInt();
        System.out.println("Enter Price");
        Scanner c4 = new Scanner(System.in);
        Double price = c4.nextDouble();

        BookDetails book = new BookDetails(bookNumber, name, count, price);
        books.add(book);
    }

    private static void deleteBook() {
        System.out.println("Enter Book Number");
        Scanner c = new Scanner(System.in);
        int bookNumber = c.nextInt();

        for (BookDetails b : books) {
            if (b.getBookNumber() == bookNumber) {
                books.remove(b);
            }
        }
    }


}