package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;

public class BibliotecaApp {

    public BibliotecaApp(PrintStream printStream, List<String> bookList) {
        printStream.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        for(String book : bookList)
            printStream.println(book);
    }
}
