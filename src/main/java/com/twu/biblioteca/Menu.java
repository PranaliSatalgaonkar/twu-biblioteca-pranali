package com.twu.biblioteca;

import java.util.Scanner;

public class Menu {

    private final Library library;

    public Menu(Library library) {
        this.library = library;
    }

    public void displayMenu() {
        System.out.println("\nMENU:\n\n1. Display books in library.\n2. Checkout Book.\n3. Return Book.\n4. Quit Application.\n\nEnter your choice : ");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        performMenuAction(option);
    }

    public void performMenuAction(int option) {
        Scanner scanner = new Scanner(System.in);
        String bookTitle;

        switch (option) {
            case 1:
                library.displayBookList();
                break;
            case 2:
                System.out.println("Enter title of the book: ");
                bookTitle = scanner.nextLine();
                library.checkoutBook(bookTitle);
                break;
            case 3:
                System.out.println("Enter title of the book : ");
                bookTitle = scanner.nextLine();
                System.out.println("Enter author : ");
                String bookAuthor = scanner.nextLine();
                System.out.println("Enter publication year : ");
                int bookPublicationYear = scanner.nextInt();
                library.returnBook(new Book(bookTitle, bookAuthor, bookPublicationYear));
                break;
            case 4:
                return;
            default:
                System.out.println("Please select a valid option!");
        }
    }
}
