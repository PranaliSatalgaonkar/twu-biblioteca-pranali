package com.twu.biblioteca;

import java.util.*;

public class Library {
    protected List<Book> bookList;
    private List<Movie> movieList;
    private Inventory inventory;
    private ConsoleSimulator consoleSimulator;
    private Map<Book, String> issuanceRegister;

    public Library(ConsoleSimulator consoleSimulator) {
        this.consoleSimulator = consoleSimulator;
        inventory = new Inventory();
        bookList = new ArrayList<>(Arrays.asList(new Book("Pride and Prejudice", "Jane Austen", 1813),
                new Book("The Diary of a Young Girl", "Anne Frank", 1947),
                new Book("To Kill a Mockingbird", "Harper Lee", 1960),
                new Book("Little Women", "Louisa May Alcott", 1868),
                new Book("The Alchemist", "Paulo Coelho", 1988)));
        movieList = new ArrayList<>(Arrays.asList(new Movie("Parasite", 2019, "Bong Joon-ho", "10"),
                new Movie("The Irishman", 2019, "Martin Scorsese", "7"),
                new Movie("Booksmart", 2019, "Olivia Wilde", "7"),
                new Movie("The Farewell", 2019, "Lulu Wang", "8"),
                new Movie("Knives Out", 2019, "Rian Johnson", "unrated")));
        issuanceRegister = new HashMap<>();
    }

    public void displayBookList() {
        for (Book book : bookList)
            consoleSimulator.display(book.getDetails());
    }

    public void displayMovieList() {
        for (Movie movie : movieList)
            consoleSimulator.display(movie.getDetails());
    }

    public void checkout(Book book) {
        consoleSimulator.display("Enter library number : ");
        String libraryNumber = consoleSimulator.scanLibraryNumber();
        consoleSimulator.display("Enter password : ");
        String password = consoleSimulator.scanPassword();
        if (new Authenticator().login(libraryNumber, password)) {
            if (isInLibrary(book)) {
                bookList.remove(book);
                issuanceRegister.put(book, libraryNumber);
                consoleSimulator.display("Thank you! Enjoy the book");
            } else
                consoleSimulator.display("Sorry, that book is not available");
        } else
            consoleSimulator.display("Invalid credentials");
    }

    public void checkout(Movie movie) {
        if (isInLibrary(movie)) {
            movieList.remove(movie);
            consoleSimulator.display("Thank you! Enjoy the movie");
        } else
            consoleSimulator.display("Sorry, that movie is not available");
    }

    public void returnBook(Book book) {
        String libraryNumber = consoleSimulator.scanLibraryNumber();
        String password = consoleSimulator.scanPassword();
        if (new Authenticator().login(libraryNumber, password)) {
            if (isBelongingToLibrary(book)) {
                bookList.add(book);
                issuanceRegister.remove(book, libraryNumber);
                consoleSimulator.display("Thank you for returning the book");
            } else {
                consoleSimulator.display("That is not a valid book to return");
            }
        } else
            consoleSimulator.display("Invalid credentials");
    }

    private boolean isInLibrary(Book book) {
        return bookList.contains(book);
    }

    private boolean isInLibrary(Movie movie) {
        return movieList.contains(movie);
    }

    private boolean isBelongingToLibrary(Book book) {
        return inventory.isInInventory(book);
    }
}
