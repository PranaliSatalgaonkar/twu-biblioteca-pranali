package com.twu.biblioteca;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

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
        String input = "1" ;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        menu.displayMenu();

        verify(library, times(1)).displayBookList();
    }

    @Test
    public void testShouldNotifyOnChoosingInvalidOption() {
        String input = "5" ;
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(mock(Library.class));
        String expectedOutput = "Please select a valid option!\n" ;
        int sc = scanner.nextInt();

        assertFalse(menu.isValidOption(sc));
        assertEquals(expectedOutput, outContent.toString());
        System.setIn(System.in);
    }
}