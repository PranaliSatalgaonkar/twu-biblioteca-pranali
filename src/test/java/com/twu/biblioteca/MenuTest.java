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
        ConsoleSimulator consoleSimulator = mock(ConsoleSimulator.class);
        Menu menu = new Menu(library, consoleSimulator);
        when(consoleSimulator.scanOption()).thenReturn(1);

        menu.display();

        verify(library, times(1)).displayList();
    }

    @Test
    public void testShouldNotifyOnChoosingInvalidOption() {
        ConsoleSimulator consoleSimulator = mock(ConsoleSimulator.class);
        Menu menu = new Menu(mock(Library.class), consoleSimulator);
        String expectedOutput = "Please select a valid option!\n";
        when(consoleSimulator.scanOption()).thenReturn(5);
        int option = consoleSimulator.scanOption();

        menu.performAction(option);

        assertEquals(expectedOutput, outContent.toString());
    }
}