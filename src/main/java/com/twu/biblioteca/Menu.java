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
            consoleSimulator.display("\nMENU:\n\n1. Display books in library.\n2. Checkout Book.\n3. Return Book.\n4. Display movies in library\n5. Checkout Movie\n6. View my details\n7. Quit Application.\n\nEnter your choice : ");
            int option = consoleSimulator.scanOption();
            if (option == 7)
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
                library.checkout(getBookDetails());
                break;
            case 3:
                library.returnBook(getBookDetails());
                break;
            case 4:
                library.displayMovieList();
                break;
            case 5:
                library.checkout(getMovieDetails());
                break;
            case 6:
                Authenticator authenticator = new Authenticator();
                User currentUser = null;
                consoleSimulator.display("Enter library number : ");
                String libraryNumber = consoleSimulator.scanLibraryNumber();
                consoleSimulator.display("Enter password : ");
                String password = consoleSimulator.scanPassword();
                if(authenticator.login(libraryNumber, password)){
                    currentUser = authenticator.retrieveCurrentUser(libraryNumber, password);
                }
                consoleSimulator.display(currentUser.getUserInformation());
                break;
            case 7:
                return;
//                System.exit(1); //todo: system.exit0
            default:
                consoleSimulator.display("Please select a valid option!");
        }
    }

    private Movie getMovieDetails() {
        consoleSimulator.scanBlankLine();
        consoleSimulator.display("Enter name of the movie: ");
        String movieName = consoleSimulator.scanMovieName();
        consoleSimulator.display("Enter release year : ");
        int movieReleaseYear = consoleSimulator.scanMovieReleaseYear();
        consoleSimulator.display("Enter name of the director : ");
        consoleSimulator.scanBlankLine();
        String movieDirector = consoleSimulator.scanMovieDirector();
        consoleSimulator.display("Enter movie rating : ");
        String movieRating = consoleSimulator.scanMovieRating();
        return new Movie(movieName, movieReleaseYear, movieDirector, movieRating);
    }

    private Book getBookDetails() {
        consoleSimulator.scanBlankLine();
        consoleSimulator.display("Enter title of the book: ");
        String bookTitle = consoleSimulator.scanBookTitle();
        consoleSimulator.display("Enter author : ");
        String bookAuthor = consoleSimulator.scanBookAuthor();
        consoleSimulator.display("Enter publication year : ");
        int bookPublicationYear = consoleSimulator.scanBookPublicationYear();
        return new Book(bookTitle, bookAuthor, bookPublicationYear);
    }

}