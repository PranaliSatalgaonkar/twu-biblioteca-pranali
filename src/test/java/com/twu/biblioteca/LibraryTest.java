package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.BookNotFoundException;
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
        Library library = new Library();
        String expectedOutput = "Pride and Prejudice Jane Austen 1813\nThe Diary of a Young Girl Anne Frank 1947\nTo Kill a Mockingbird Harper Lee 1960\nLittle Women Louisa May Alcott 1868\n" ;

        library.displayBookList();

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testShouldCheckoutABook() {
        Library library = new Library();

        library.checkOut("Pride and Prejudice");

        assertThrows(BookNotFoundException.class, () -> library.getBook("Pride and Prejudice"));
    }

    @Test
    public void testShouldNotifyOnSuccessfulCheckout() {
        Library library = new Library();
        String expectedOutput = "Thank you! Enjoy the book\n" ;

        library.checkOut("The Diary of a Young Girl");

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testShouldNotifyOnUnsuccessfulCheckout() {
        Library library = new Library();
        String expectedOutput = "Sorry, that book is not available\n" ;

        library.checkOut("The Alchemist");

        assertEquals(expectedOutput, outContent.toString());
    }
}