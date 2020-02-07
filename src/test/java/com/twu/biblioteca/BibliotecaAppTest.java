package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BibliotecaAppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void testShouldPrintWelcomeMessageOnConsole() {
        String expectedOutput = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n" ;

        BibliotecaApp bibliotecaApp = new BibliotecaApp(new PrintStream(outContent), Collections.emptyList());

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testShouldEnlistAllLibraryBooks() {
        StringBuilder expectedOutput = new StringBuilder("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n");
        List<String> bookList = Arrays.asList("Pride and Prejudice", "The Diary of Anne Frank", "To Kill a Mockingbird", "Little Women");
        for(String book : bookList)
            expectedOutput.append(book).append("\n");
        BibliotecaApp bibliotecaApp = new BibliotecaApp(new PrintStream(outContent), bookList);

        assertEquals(expectedOutput.toString(), outContent.toString());
    }
}