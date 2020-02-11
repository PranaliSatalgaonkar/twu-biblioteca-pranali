package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class MenuTest {

    @Test
    public void testShouldCallMenu() {
        Library library = mock(Library.class);
        ConsoleSimulator consoleSimulator = mock(ConsoleSimulator.class);
        Menu menu = new Menu(library, consoleSimulator);
        when(consoleSimulator.scanOption()).thenReturn(1, 4);

        menu.display();

        verify(library, times(1)).displayBookList();
    }

    @Test
    public void testShouldNotifyOnChoosingInvalidOption() {
        ConsoleSimulator consoleSimulator = mock(ConsoleSimulator.class);
        Menu menu = new Menu(mock(Library.class), consoleSimulator);
        when(consoleSimulator.scanOption()).thenReturn(5);
        int option = consoleSimulator.scanOption();

        menu.performAction(option);

        verify(consoleSimulator, times(1)).display("Please select a valid option!");

    }
}