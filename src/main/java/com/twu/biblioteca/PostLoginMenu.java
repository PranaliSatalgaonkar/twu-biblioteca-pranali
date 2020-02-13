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
            if (option == 5)
                break;
            performPostLoginAction(option);
        }
    }

    public void performPostLoginAction(int option) {
        switch (option) {
            case 1:
                library.checkout(getBookDetails());
                break;
            case 2:
                library.returnBook(getBookDetails());
                break;
            case 3:
                library.checkout(getMovieDetails());
                break;
            case 4:
                consoleSimulator.display(currentUser.getUserInformation());
                break;
            case 5:
                return;
            default:
                consoleSimulator.display("Please select a valid option!");
        }
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

}
