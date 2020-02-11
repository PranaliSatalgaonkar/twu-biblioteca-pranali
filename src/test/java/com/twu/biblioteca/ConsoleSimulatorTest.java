package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleSimulatorTest {

    @Test
    public void testShouldReturnScannedOption() {
        String input = "2" ;
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ConsoleSimulator consoleSimulator = new ConsoleSimulator();
        int option = consoleSimulator.scanOption();
        assertEquals(2, option);
        System.setIn(System.in);
    }

    @Test
    public void testShouldReturnScannedString() {
        String input = "user input string" ;
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ConsoleSimulator consoleSimulator = new ConsoleSimulator();
        String title = consoleSimulator.scanBookTitle();
        assertEquals("user input string", title);
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