package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.BookNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;

public class Library {
    ArrayList<Book> bookList;

    public Library() {
        bookList = new ArrayList<>(Arrays.asList(new Book("Pride and Prejudice", "Jane Austen", 1813),
                new Book("The Diary of a Young Girl", "Anne Frank", 1947),
                new Book("To Kill a Mockingbird", "Harper Lee", 1960),
                new Book("Little Women", "Louisa May Alcott", 1868)));
    }

    void displayBookList() {
        for (Book book : bookList)
            System.out.println(book.getBookDetails());
    }

    public void checkOut(String title) throws BookNotFoundException {
        Book book = getBook(title);
        bookList.remove(book);
        displayBookList();
    }

    private Book getBook(String title) throws BookNotFoundException {
        for (Book book : bookList) {
            if (book.title.equals(title))
                return book;
        }
        throw new BookNotFoundException();
    }
}
