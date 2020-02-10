package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        new BibliotecaApp(new Menu(new Library(), new ConsoleSimulator()));
    }

    public BibliotecaApp(Menu menu) {
        displayWelcomeMessage();
        menu.display();
    }

    private void displayWelcomeMessage() {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }
}
