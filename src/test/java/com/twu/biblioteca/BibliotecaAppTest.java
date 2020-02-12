package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class BibliotecaAppTest {

    @Test
    public void testShouldPrintWelcomeMessageOnConsole() {
        String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        String menu = "\nMENU:\n\n1. Display books in library.\n2. Checkout Book.\n3. Return Book.\n4. Display movies in library\n5. Checkout Movie\n6. View my details\n7. Quit Application.\n\nEnter your choice : ";

        ConsoleSimulator consoleSimulator = mock(ConsoleSimulator.class);
        doReturn(4).when(consoleSimulator).scanOption();

        new BibliotecaApp(consoleSimulator).start(new Menu(new Library(consoleSimulator), consoleSimulator));

        verify(consoleSimulator, times(1)).display(welcomeMessage);
        verify(consoleSimulator, times(1)).display(menu);
    }

    @Test
    public void testShouldDisplayMenuOnStartingApplication() {
        Menu menu = mock(Menu.class);

        new BibliotecaApp(mock(ConsoleSimulator.class)).start(menu);

        verify(menu, times(1)).display();
    }
}