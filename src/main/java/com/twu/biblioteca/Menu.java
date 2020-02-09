package com.twu.biblioteca;

import java.util.Scanner;

public class Menu {

    private final Library library;

    public Menu(Library library) {
        this.library = library;
    }

    public void displayMenu() {
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
            library.checkoutBook("");
        }
        if (option == 3) {
            library.returnBook(new Book("", "", 0));
        }
        if (option == 4) {
            return;
        }
    }
}
