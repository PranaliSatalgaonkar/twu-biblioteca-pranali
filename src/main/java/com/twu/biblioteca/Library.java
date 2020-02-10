package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public class Library {
    ArrayList<Book> bookList;
    Inventory inventory;

    public Library() {
        inventory = new Inventory();
        bookList = new ArrayList<>(Arrays.asList(new Book("Pride and Prejudice", "Jane Austen", 1813),
                new Book("The Diary of a Young Girl", "Anne Frank", 1947),
                new Book("To Kill a Mockingbird", "Harper Lee", 1960),
                new Book("Little Women", "Louisa May Alcott", 1868),
                new Book("The Alchemist", "Paulo Coelho", 1988)));
    }

    void displayBookList() {
        for (Book book : bookList)
            System.out.println(book.getBookDetails());
    }

    public void checkoutBook(String title) {
        Book book = getBook(title);
        if (book == null)
            System.out.println("Sorry, that book is not available");
        else {
            bookList.remove(book);
            System.out.println("Thank you! Enjoy the book");
        }
    }

    protected Book getBook(String title) {
        for (Book book : bookList) {
            if (book.title.equals(title))
                return book;
        }
        return null;
    }

    public void returnBook(Book book) {
        if (isValidBook(book)) {
            bookList.add(book);
            System.out.println("Thank you for returning the book");
        }
    }

    private boolean isValidBook(Book book) {
        if (!inventory.isInInventory(book)) {
            System.out.println("That is not a valid book to return");
            return false;
        }
        return true;
    }
}
