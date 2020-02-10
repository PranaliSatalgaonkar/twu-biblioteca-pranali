package com.twu.biblioteca;


public class Menu {

    private final Library library;
    private InputScanner inputScanner;

    public Menu(Library library, InputScanner inputScanner) {
        this.library = library;
        this.inputScanner = inputScanner;
    }

    public void displayMenu() {
        System.out.println("\nMENU:\n\n1. Display books in library.\n2. Checkout Book.\n3. Return Book.\n4. Quit Application.\n\nEnter your choice : ");
        int option = inputScanner.scanOption();

        performAction(option);
    } //TODO: display

    public void performAction(int option) {
        String bookTitle;

        switch (option) { // TODO: can this be cleaner ?
            case 1:
                library.displayList();
                break;
            case 2:
                System.out.println("Enter title of the book: ");
                bookTitle = inputScanner.scanBookTitle();
                library.checkout(bookTitle);
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
//                System.exit(1);
            default:
                System.out.println("Please select a valid option!");
        }
    }
}
