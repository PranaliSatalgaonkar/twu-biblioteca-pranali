package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BibliotecaAppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void testShouldPrintWelcomeMessageOnConsole() {
        String expectedOutput = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!" ;

        BibliotecaApp bibliotecaApp = new BibliotecaApp(new PrintStream(outContent));

        assertEquals(expectedOutput, outContent.toString());
    }
}