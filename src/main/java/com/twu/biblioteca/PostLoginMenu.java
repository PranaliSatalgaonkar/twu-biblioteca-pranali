package com.twu.biblioteca;

public class PostLoginMenu {
    private final Library library;
    private ConsoleSimulator consoleSimulator;
    private User currentUser;

    public PostLoginMenu(Library library, ConsoleSimulator consoleSimulator, User currentUser) {
        this.library = library;
        this.consoleSimulator = consoleSimulator;
        this.currentUser = currentUser;
    }

    public void displayPostLoginMenu() {
        while (true) {
            consoleSimulator.display("\nMENU:\n\n1. Checkout book.\n2. Return book.\n3. Checkout movie\n4. View my details.\n5. Go back.\n\nEnter your choice : ");
            int option = consoleSimulator.scanOption();
            if (option == 2)
                break;
            performPostLoginAction(option);
        }
    }

    public void performPostLoginAction(int option) {
        switch (option) {
            case 1:
                library.checkout((Book) null);
                break;
        }
    }
}
