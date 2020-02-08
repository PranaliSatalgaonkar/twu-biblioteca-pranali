package com.twu.biblioteca;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MenuTest {

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
    public void testShouldCallMenu() {
        Library library = mock(Library.class);
        Menu menu = new Menu(library);

        menu.displayMenu();

        verify(library, times(1)).displayBookList();
    }

    @Test
    void testShouldNotifyOnChoosingInvalidOption() {
        Menu menu = new Menu(new Library());
        String expectedOutput = "Please select a valid option!\n";

        assertFalse(menu.isValidOption(0));
        assertEquals(expectedOutput, outContent.toString());
    }
}