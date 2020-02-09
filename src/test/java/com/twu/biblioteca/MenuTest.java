package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.BookNotFoundException;
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
    public void testShouldCallMenu() throws BookNotFoundException {
        Library library = mock(Library.class);
        Menu menu = new Menu(library);

        menu.displayMenu();

        verify(library, times(1)).displayBookList();
    }

    @Test
    public void testShouldNotifyOnChoosingInvalidOption() {
        Menu menu = new Menu(mock(Library.class));
        String expectedOutput = "Please select a valid option!\n" ;

        assertFalse(menu.isValidOption(0));
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testShouldCheckoutABook() throws BookNotFoundException {
        Menu menu = new Menu(new Library());

        menu.performMenuAction(2);

        assertThrows(BookNotFoundException.class, ()-> menu.performMenuAction(2));
    }
}