package com.twu.biblioteca;

public class BibliotecaApp {

    public BibliotecaApp(Library library) {
        displayWelcomeMessage();
        library.displayBookList();
    }

    void displayWelcomeMessage() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }
}
