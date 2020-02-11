package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

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
}