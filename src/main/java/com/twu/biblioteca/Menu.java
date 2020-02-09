package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.BookNotFoundException;

public class Menu {

    private final Library library;

    public Menu(Library library) {
        this.library = library;
    }

    public void displayMenu() throws BookNotFoundException {
        int option = 1;
        if (isValidOption(option))
            performMenuAction(option);
    }

    protected boolean isValidOption(int option) {
        if (option == 1)
            return true;
        notifyCustomer();
        return false;
    }

    private void notifyCustomer() {
        System.out.println("Please select a valid option!");
    }

    public void performMenuAction(int option) throws BookNotFoundException {
        if (option == 1) {
            library.displayBookList();
        }
        if (option == 2) {
            library.checkOut("Pride and Prejudice");
        }
    }
}
