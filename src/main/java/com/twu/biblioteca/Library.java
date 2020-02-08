package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;

public class Library {
    List<Book> bookList;

    public Library() {
        bookList = Arrays.asList(new Book("Pride and Prejudice", "Jane Austen", 1813),
                new Book("The Diary of a Young Girl", "Anne Frank", 1947),
                new Book("To Kill a Mockingbird", "Harper Lee", 1960),
                new Book("Little Women", "Louisa May Alcott", 1868));
    }

    void displayBookList() {
        for (Book book : bookList)
            System.out.println(book.getBookDetails());
    }
}
