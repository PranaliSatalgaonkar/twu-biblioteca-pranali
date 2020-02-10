package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library {
    //TODO : structure, d, c, p , a, internal apis
    private List<Book> bookList;
    private Inventory inventory;

    public Library() {
        inventory = new Inventory();
        bookList = new ArrayList<>(Arrays.asList(new Book("Pride and Prejudice", "Jane Austen", 1813),
                new Book("The Diary of a Young Girl", "Anne Frank", 1947),
                new Book("To Kill a Mockingbird", "Harper Lee", 1960),
                new Book("Little Women", "Louisa May Alcott", 1868),
                new Book("The Alchemist", "Paulo Coelho", 1988)));
    }

    public void displayList() {
        for (Book book : bookList)
            System.out.println(book.getDetails());
    }

    public void checkout(String title) {
        Book book = getBook(title);
        if (book == null)
            System.out.println("Sorry, that book is not available"); // TODO: is this srp
        else {
            bookList.remove(book);
            System.out.println("Thank you! Enjoy the book");  // TODO: is this srp
        }
    }

    public void returnBook(Book book) {
        if (isValidBook(book)) {
            bookList.add(book);
            System.out.println("Thank you for returning the book");  // TODO: is this srp
        }
    }

    protected Book getBook(String title) { //TODO: private
        for (Book book : bookList) {
            if (book.title.equals(title)) // TODO: compare books instead of title
                return book;
        }
        return null;
    }

    private boolean isValidBook(Book book) {
        if (!inventory.isInInventory(book)) {
            System.out.println("That is not a valid book to return");
            return false;
        }
        return true;
    }
}
