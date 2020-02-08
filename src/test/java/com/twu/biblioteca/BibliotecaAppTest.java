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

        new BibliotecaApp(new PrintStream(outContent), Collections.emptyList());

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testShouldEnlistAllLibraryBooks() {
        StringBuilder expectedOutput = new StringBuilder("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n");
        List<Book> bookList = Arrays.asList(new Book("Pride and Prejudice", "Jane Austen", 1813), new Book("The Diary of a Young Girl", "Anne Frank", 1947), new Book("To Kill a Mockingbird", "Harper Lee", 1960), new Book("Little Women", "Louisa May Alcott", 1868));
        for (Book book : bookList)
            expectedOutput.append(book.title).append(" ").append(book.author).append(" ").append(book.publicationYear).append("\n");

        new BibliotecaApp(new PrintStream(outContent), bookList);

        assertEquals(expectedOutput.toString(), outContent.toString());
    }
}