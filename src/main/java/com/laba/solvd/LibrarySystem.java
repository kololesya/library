package com.laba.solvd;

import java.util.HashMap;
import java.util.Scanner;

public class LibrarySystem {
    static Scanner sc = new Scanner(System.in);
    private static HashMap<String, Book> library = new HashMap<>();

    static int getValidIntegerInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.next(); // Clear invalid input
        }
        int number = scanner.nextInt(); //Read the valid number
        scanner.nextLine(); //clear the last char of the input
        return number;
    }

    public static void addBooks() {
        System.out.print("Enter book title: ");
        String title = sc.nextLine(); // Read the book title
        System.out.print("Enter author name: ");
        String author = sc.nextLine(); // Read the author name
        System.out.print("Enter quantity to add: ");
        int quantity = getValidIntegerInput(sc); // Get the positive integer

        library.putIfAbsent(title.toLowerCase(), new Book(title, author, 0));
        Book book = library.get(title.toLowerCase());
        book.quantity += quantity;

        System.out.println("Successfully added/updated book: " + title);
    }

    public static void borrowBooks() {
        System.out.print("Enter book title: ");
        String title = sc.nextLine();
        System.out.print("Enter quantity to borrow: ");
        int quantity = getValidIntegerInput(sc);

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

    public static void returnBooks() {
        System.out.print("Enter book title: ");
        String title = sc.nextLine();
        System.out.print("Enter quantity to return: ");
        int quantity = getValidIntegerInput(sc);

        Book book = library.get(title.toLowerCase());
        if (book == null) {
            System.out.println("Error: This book does not belong to the library.");
        } else {
            book.quantity += quantity;
            System.out.println("Successfully returned " + quantity + " copies of \"" + book.title + "\".");
        }
    }
}
