package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleSimulatorTest {

    @Test
    public void testShouldReturnScannedOption() {
        String input = "2";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ConsoleSimulator consoleSimulator = new ConsoleSimulator();
        int option = consoleSimulator.scanOption();
        assertEquals(2, option);
        System.setIn(System.in);
    }

    @Test
    public void testShouldReturnScannedBookTitle() {
        String input = "book title";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ConsoleSimulator consoleSimulator = new ConsoleSimulator();
        String title = consoleSimulator.scanBookTitle();
        assertEquals("book title", title);
        System.setIn(System.in);
    }

    @Test
    public void testShouldReturnScannedBookAuthor() {
        String input = "book author";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ConsoleSimulator consoleSimulator = new ConsoleSimulator();
        String author = consoleSimulator.scanBookAuthor();
        assertEquals("book author", author);
        System.setIn(System.in);
    }

    @Test
    public void testShouldReturnScannedBookPublicationYear() {
        String input = "1974";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ConsoleSimulator consoleSimulator = new ConsoleSimulator();
        int publicationYear = consoleSimulator.scanBookPublicationYear();
        assertEquals(1974, publicationYear);
        System.setIn(System.in);
    }

    @Test
    public void testShouldReturnScannedLibraryNumber() {
        String input = "999-9999";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ConsoleSimulator consoleSimulator = new ConsoleSimulator();
        String libraryNumber = consoleSimulator.scanLibraryNumber();
        assertEquals("999-9999", libraryNumber);
        System.setIn(System.in);
    }

    @Test
    public void testShouldReturnScannedPassword() {
        String input = "abcd";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ConsoleSimulator consoleSimulator = new ConsoleSimulator();
        String password = consoleSimulator.scanPassword();
        assertEquals("abcd", password);
        System.setIn(System.in);
    }

    @Test
    public void testShouldDisplayMessage() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        ConsoleSimulator consoleSimulator = new ConsoleSimulator();
        consoleSimulator.display("display message");
        assertEquals("display message\n", outContent.toString());
        System.setOut(System.out);
    }
}