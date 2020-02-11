package com.twu.biblioteca;


public class Menu {
    private final Library library;
    private ConsoleSimulator consoleSimulator;

    public Menu(Library library, ConsoleSimulator consoleSimulator) {
        this.library = library;
        this.consoleSimulator = consoleSimulator;
    }

    public void display() {
        while (true) {
            consoleSimulator.display("\nMENU:\n\n1. Display books in library.\n2. Checkout Book.\n3. Return Book.\n4. Quit Application.\n\nEnter your choice : ");
            int option = consoleSimulator.scanOption();
            if (option == 4)
                break;
            performAction(option);
        }
    }

    public void performAction(int option) {
        switch (option) {//TODO: loop
            case 1:
                library.displayList();
                break;
            case 2:
                library.checkout(getBookDetails());
                break;
            case 3:
                library.returnBook(getBookDetails());
                break;
            case 4:
                return;
//                System.exit(1); //todo: system.exit0
            default:
                System.out.println("Please select a valid option!");
        }
    }

    private Book getBookDetails() {
        consoleSimulator.scanBlankLine();
        consoleSimulator.display("Enter title of the book: ");
        String bookTitle = consoleSimulator.scanBookTitle();
        consoleSimulator.display("Enter author : ");
        String bookAuthor = consoleSimulator.scanBookAuthor();
        consoleSimulator.display("Enter publication year : ");
        int bookPublicationYear = consoleSimulator.scanBookPublicationYear();
        return new Book(bookTitle, bookAuthor, bookPublicationYear);
    }

}
