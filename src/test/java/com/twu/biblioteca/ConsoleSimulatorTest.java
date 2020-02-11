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

}