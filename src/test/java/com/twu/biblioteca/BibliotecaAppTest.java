package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.BookNotFoundException;
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
    public void testShouldPrintWelcomeMessageOnConsole() throws BookNotFoundException {
        String expectedOutput = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\nPride and Prejudice Jane Austen 1813\nThe Diary of a Young Girl Anne Frank 1947\nTo Kill a Mockingbird Harper Lee 1960\nLittle Women Louisa May Alcott 1868\n" ;

        new BibliotecaApp(new Menu(new Library()));

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testShouldDisplayMenuOnStartingApplication() throws BookNotFoundException {
        Menu menu = mock(Menu.class);

        new BibliotecaApp(menu);

        verify(menu, times(1)).displayMenu();
    }
}