package com.twu.biblioteca;

public class Menu {

    private final Library library;

    public Menu(Library library) {
        this.library = library;
    }

    public void displayMenu() {
        library.displayBookList();
    }
}
