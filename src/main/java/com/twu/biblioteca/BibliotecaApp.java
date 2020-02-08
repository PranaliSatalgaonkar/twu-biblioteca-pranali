package com.twu.biblioteca;

public class BibliotecaApp {

    public BibliotecaApp(Menu menu, Library library) {
        displayWelcomeMessage();
        menu.displayMenu(library);
    }

    void displayWelcomeMessage() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }
}
