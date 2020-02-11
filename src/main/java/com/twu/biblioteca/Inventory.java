package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;

public class Inventory {
    private List<Book> inventoryBookList;
    private List<Movie> inventoryMovieList;

    public Inventory() {
        inventoryBookList = Arrays.asList(new Book("Pride and Prejudice", "Jane Austen", 1813),
                new Book("The Diary of a Young Girl", "Anne Frank", 1947),
                new Book("To Kill a Mockingbird", "Harper Lee", 1960),
                new Book("Little Women", "Louisa May Alcott", 1868),
                new Book("The Alchemist", "Paulo Coelho", 1988));

        inventoryMovieList = Arrays.asList(new Movie("Parasite", 2019, "Bong Joon-ho", "10"),
                new Movie("The Irishman", 2019, "Martin Scorsese", "7"),
                new Movie("Booksmart", 2019, "Olivia Wilde", "7"),
                new Movie("The Farewell", 2019, "Lulu Wang", "8"),
                new Movie("Knives Out", 2019, "Rian Johnson", "unrated"));
    }

    public boolean isInInventory(Book book) {
        return inventoryBookList.contains(book);
    }

    public boolean isInInventory(Movie movie) {
        return inventoryMovieList.contains(movie);
    }
}
