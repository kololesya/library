package com.laba.solvd;

import java.util.Scanner;
import static com.laba.solvd.LibrarySystem.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLibrary System Menu:");
            System.out.println("1. Add Books");
            System.out.println("2. Borrow Books");
            System.out.println("3. Return Books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = getValidIntegerInput(sc);

            switch (choice) {
                case 1 -> addBooks();
                case 2 -> borrowBooks();
                case 3 -> returnBooks();
                case 4 -> System.out.println("Exiting the Library System. Goodbye!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}