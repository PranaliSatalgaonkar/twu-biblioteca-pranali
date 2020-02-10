package com.twu.biblioteca;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BibliotecaAppTest {

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
    public void testShouldPrintWelcomeMessageOnConsole() {
        String expectedOutput = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n\nMENU:\n\n1. Display books in library.\n2. Checkout Book.\n3. Return Book.\n4. Quit Application.\n\nEnter your choice : \n" ;

        ConsoleSimulator consoleSimulator = mock(ConsoleSimulator.class);
        doReturn(4).when(consoleSimulator).scanOption();

        new BibliotecaApp(new Menu(new Library(), consoleSimulator));

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testShouldDisplayMenuOnStartingApplication() {
        Menu menu = mock(Menu.class);

        new BibliotecaApp(menu);

        verify(menu, times(1)).display();
    }
}