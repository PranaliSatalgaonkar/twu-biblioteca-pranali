package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class BibliotecaApp {

    PrintStream printStream;
    List<Book> bookList;

    public BibliotecaApp(PrintStream printStream, List<Book> bookList) {
        this.printStream = printStream;
        this.bookList = bookList;

        showWelcomeMessage();
        showBookList();
    }

    void showWelcomeMessage() {
        printStream.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    void showBookList() {
        for (Book book : bookList)
            printStream.println(book.title + " " + book.author + " " + book.publicationYear);
    }
}
