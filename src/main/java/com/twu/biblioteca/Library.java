package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library {
    private List<Book> bookList;
    private Inventory inventory;
    private ConsoleSimulator consoleSimulator;

    public Library(ConsoleSimulator consoleSimulator) {
        this.consoleSimulator = consoleSimulator;
        inventory = new Inventory();
        bookList = new ArrayList<>(Arrays.asList(new Book("Pride and Prejudice", "Jane Austen", 1813),
                new Book("The Diary of a Young Girl", "Anne Frank", 1947),
                new Book("To Kill a Mockingbird", "Harper Lee", 1960),
                new Book("Little Women", "Louisa May Alcott", 1868),
                new Book("The Alchemist", "Paulo Coelho", 1988)));
    }

    public void displayList() {
        for (Book book : bookList)
            consoleSimulator.display(book.getDetails());
    }

    public void checkout(Book book) {
        if (isInLibrary(book)) {
            bookList.remove(book);
            consoleSimulator.display("Thank you! Enjoy the book");
        } else
            consoleSimulator.display("Sorry, that book is not available");
    }

    public void returnBook(Book book) {
        if (isBelongingToLibrary(book)) {
            bookList.add(book);
            consoleSimulator.display("Thank you for returning the book");
        }
    }

    private boolean isInLibrary(Book book) {
        return bookList.contains(book);
    }

    private boolean isBelongingToLibrary(Book book) {
        if (!inventory.isInInventory(book)) {
            consoleSimulator.display("That is not a valid book to return");
            return false;
        }
        return true;
    }
}
