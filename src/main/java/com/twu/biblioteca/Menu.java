package com.twu.biblioteca;


public class Menu {

    private final Library library;
    private final InputScanner inputScanner;

    public Menu(Library library, InputScanner inputScanner) {
        this.library = library;
        this.inputScanner = inputScanner;
    }

    public void displayMenu() {
        System.out.println("\nMENU:\n\n1. Display books in library.\n2. Checkout Book.\n3. Return Book.\n4. Quit Application.\n\nEnter your choice : ");
        int option = inputScanner.scanOption();

        performMenuAction(option);
    }

    public void performMenuAction(int option) {
        String bookTitle;

        switch (option) {
            case 1:
                library.displayBookList();
                break;
            case 2:
                System.out.println("Enter title of the book: ");
                bookTitle = inputScanner.scanBookTitle();
                library.checkoutBook(bookTitle);
                break;
            case 3:
                System.out.println("Enter title of the book : ");
                bookTitle = inputScanner.scanBookTitle();
                System.out.println("Enter author : ");
                String bookAuthor = inputScanner.scanBookAuthor();
                System.out.println("Enter publication year : ");
                int bookPublicationYear = inputScanner.scanBookPublicationYear();
                library.returnBook(new Book(bookTitle, bookAuthor, bookPublicationYear));
                break;
            case 4:
                return;
            default:
                System.out.println("Please select a valid option!");
        }
    }
}
