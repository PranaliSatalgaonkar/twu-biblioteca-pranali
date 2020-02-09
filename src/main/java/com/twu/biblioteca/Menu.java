package com.twu.biblioteca;

import java.util.Scanner;

public class Menu {

    private final Library library;

    public Menu(Library library) {
        this.library = library;
    }

    public void displayMenu() {
        System.out.print("\nMENU:\n\n1. Display books in library.\n2. Checkout Book.\n3. Return Book.\n4. Quit Application.\n\nEnter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        if (isValidOption(option))
            performMenuAction(option);
    }

    protected boolean isValidOption(int option) {
        if (option > 0 && option < 5)
            return true;
        notifyCustomer();
        return false;
    }

    private void notifyCustomer() {
        System.out.println("Please select a valid option!");
    }

    public void performMenuAction(int option) {
        if (option == 1) {
            library.displayBookList();
        }
        if (option == 2) {
            System.out.print("\nEnter title of the book: ");
            Scanner scanner = new Scanner(System.in);
            String bookTitle = scanner.nextLine();
            library.checkoutBook(bookTitle);
        }
        if (option == 3) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nEnter title of the book : ");
            String bookTitle = scanner.nextLine();
            System.out.print("\nEnter author : ");
            String bookAuthor= scanner.nextLine();
            System.out.print("\nEnter publication year : ");
            int bookPublicationYear = scanner.nextInt();
            library.returnBook(new Book(bookTitle, bookAuthor, bookPublicationYear));
        }
        if (option == 4) {
            return;
        }
    }
}
