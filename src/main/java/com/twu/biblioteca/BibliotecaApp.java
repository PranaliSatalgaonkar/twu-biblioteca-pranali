package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        new BibliotecaApp(new Menu(new Library()));
    }

    public BibliotecaApp(Menu menu) {
        displayWelcomeMessage();
        menu.displayMenu();
    }

    void displayWelcomeMessage() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }
}
