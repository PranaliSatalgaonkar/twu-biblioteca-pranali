package com.twu.biblioteca;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void reset() {
        System.setOut(System.out);
    }

    @Test
    public void testShouldDisplayBookList() {
        Library library = new Library(new ConsoleSimulator());
        String expectedOutput = "Pride and Prejudice Jane Austen 1813\nThe Diary of a Young Girl Anne Frank 1947\nTo Kill a Mockingbird Harper Lee 1960\nLittle Women Louisa May Alcott 1868\nThe Alchemist Paulo Coelho 1988\n";

        library.displayList();

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testShouldCheckoutABook() {
        Library library = new Library(new ConsoleSimulator());
        String expectedOutput = "Thank you! Enjoy the book\nSorry, that book is not available\n";

        library.checkout(new Book("Pride and Prejudice", "Jane Austen", 1813));
        library.checkout(new Book("Pride and Prejudice", "Jane Austen", 1813));

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testShouldNotifyOnSuccessfulCheckout() {
        Library library = new Library(new ConsoleSimulator());
        String expectedOutput = "Thank you! Enjoy the book\n";

        library.checkout(new Book("The Diary of a Young Girl", "Anne Frank", 1947));

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testShouldNotifyOnUnsuccessfulCheckout() {
        Library library = new Library(new ConsoleSimulator());
        String expectedOutput = "Sorry, that book is not available\n";

        library.checkout(new Book("The Secret Seven", "Enid Blyton", 1949));

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testShouldReturnABook() {
        Library library = new Library(new ConsoleSimulator());
        String expectedOutput = "Thank you for returning the book\nPride and Prejudice Jane Austen 1813\nThe Diary of a Young Girl Anne Frank 1947\nTo Kill a Mockingbird Harper Lee 1960\nLittle Women Louisa May Alcott 1868\nThe Alchemist Paulo Coelho 1988\nThe Alchemist Paulo Coelho 1988\n";

        library.returnBook(new Book("The Alchemist", "Paulo Coelho", 1988));
        library.displayList();

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testShouldNotifyOnSuccessfulReturn() {
        Library library = new Library(new ConsoleSimulator());
        String expectedOutput = "Thank you for returning the book\n";

        library.returnBook(new Book("The Alchemist", "Paulo Coelho", 1988));

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testShouldNotifyOnUnsuccessfulReturn() {
        Library library = new Library(new ConsoleSimulator());
        String expectedOutput = "That is not a valid book to return\n";

        library.returnBook(new Book("Alchemist", "Paulo Coelho", 1988));

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testShouldDisplayMovieList() {
        Library library = new Library(new ConsoleSimulator());
        String expectedOutput = "Parasite 2019 Bong Joon-ho 10\nThe Irishman 2019 Martin Scorsese 7\nBooksmart 2019 Olivia Wilde 7\nThe Farewell 2019 Lulu Wang 8\nKnives Out 2019 Rian Johnson unrated\n";

        library.displayMovieList();

        assertEquals(expectedOutput, outContent.toString());
    }
}