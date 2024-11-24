package com.laba.solvd;

import java.util.HashMap;
import java.util.Scanner;

public class LibrarySystem {
    private static HashMap<String, Book> library = new HashMap<>();

    static int getValidIntegerInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
    public static void addBooks(Scanner scanner) {
        System.out.println("Enter book title: ");
        String title = scanner.nextLine();

        System.out.println("Enter author name: ");
        String author = scanner.nextLine();

        System.out.println("Enter quantity to add: ");
        int quantity = getValidIntegerInput(scanner);

        library.putIfAbsent(title.toLowerCase(), new Book(title, author, 0));
        Book book = library.get(title.toLowerCase());
        book.quantity += quantity;

        System.out.println("Successfully added/updated book: " + title);
    }

    public static void borrowBooks(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter quantity to borrow: ");
        int quantity = getValidIntegerInput(scanner);

        Book book = library.get(title.toLowerCase());
        if (book == null) {
            System.out.println("Error: Book not found in the library.");
        } else if (book.quantity < quantity) {
            System.out.println("Error: Insufficient quantity available. Available: " + book.quantity);
        } else {
            book.quantity -= quantity;
            System.out.println("Successfully borrowed " + quantity + " copies of \"" + book.title + "\".");
        }
    }

    public static void returnBooks(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter quantity to return: ");
        int quantity = getValidIntegerInput(scanner);

        Book book = library.get(title.toLowerCase());
        if (book == null) {
            System.out.println("Error: This book does not belong to the library.");
        } else {
            book.quantity += quantity;
            System.out.println("Successfully returned " + quantity + " copies of \"" + book.title + "\".");
        }
    }
}
