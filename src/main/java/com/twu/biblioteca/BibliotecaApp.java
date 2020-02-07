package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class BibliotecaApp {

    PrintStream printStream;
    List<String> bookList;

    public BibliotecaApp(PrintStream printStream, List<String> bookList) {
        this.printStream = printStream;
        this.bookList = bookList;

        showWelcomeMessage();
        showBookList();
    }

    void showWelcomeMessage() {
        printStream.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    void showBookList() {
        for (String book : bookList)
            printStream.println(book);
    }
}
