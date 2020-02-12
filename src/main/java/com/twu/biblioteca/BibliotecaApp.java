package com.twu.biblioteca;

public class BibliotecaApp {
    private ConsoleSimulator consoleSimulator;

    public static void main(String[] args) {
        new BibliotecaApp(new ConsoleSimulator()).start(new Menu(new Library(new ConsoleSimulator()), new ConsoleSimulator()));
    }

    public BibliotecaApp(ConsoleSimulator consoleSimulator) {
        this.consoleSimulator = consoleSimulator;
    }

    public void start(Menu menu) {
        displayWelcomeMessage();
        menu.display();
    }

    private void displayWelcomeMessage() {
        consoleSimulator.display("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }
}
