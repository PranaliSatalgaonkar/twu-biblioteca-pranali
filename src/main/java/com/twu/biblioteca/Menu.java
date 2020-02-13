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
            consoleSimulator.display("\nMENU:\n\n1. Display books in library.\n2. Display movies in library\n3. Login. (to avail library facilities)\n4. Quit Application.\n\nEnter your choice : ");
            int option = consoleSimulator.scanOption();
            if (option == 4)
                break;
            performAction(option);
        }
    }

    public void performAction(int option) {
        switch (option) {
            case 1:
                library.displayBookList();
                break;
            case 2:
                library.displayMovieList();
                break;
            case 3:
                Authenticator authenticator = new Authenticator();
                User currentUser;
                consoleSimulator.display("Enter library number : ");
                String libraryNumber = consoleSimulator.scanLibraryNumber();
                consoleSimulator.display("Enter password : ");
                String password = consoleSimulator.scanPassword();
                if (authenticator.login(libraryNumber, password)) {
                    currentUser = authenticator.retrieveCurrentUser(libraryNumber, password);
                    new PostLoginMenu(library, consoleSimulator, currentUser).displayPostLoginMenu();
                }
                break;
            case 4:
                return;
//                System.exit(1); //todo: system.exit0
            default:
                consoleSimulator.display("Please select a valid option!");
        }
    }
}