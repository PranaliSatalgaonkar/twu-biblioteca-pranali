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
        InputScanner inputScanner = mock(InputScanner.class);
        Menu menu = new Menu(library, inputScanner);
        when(inputScanner.scanOption()).thenReturn(1);

        menu.displayMenu();

        verify(library, times(1)).displayBookList();
    }

    @Test
    public void testShouldNotifyOnChoosingInvalidOption() {
        InputScanner inputScanner = mock(InputScanner.class);
        Menu menu = new Menu(mock(Library.class), inputScanner);
        String expectedOutput = "Please select a valid option!\n" ;
        when(inputScanner.scanOption()).thenReturn(5);
        int option = inputScanner.scanOption();

        menu.performAction(option);

        assertEquals(expectedOutput, outContent.toString());
        System.setIn(System.in);
    }
}