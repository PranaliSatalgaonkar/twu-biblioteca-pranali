package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.BookNotFoundException;

public class BibliotecaApp {

    public BibliotecaApp(Menu menu) throws BookNotFoundException {
        displayWelcomeMessage();
        menu.displayMenu();
    }

    void displayWelcomeMessage() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }
}
