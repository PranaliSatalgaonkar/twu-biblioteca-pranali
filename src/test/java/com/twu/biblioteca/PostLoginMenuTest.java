package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class PostLoginMenuTest {

    @Test
    public void testShouldCallMenu() {
        Library library = mock(Library.class);
        ConsoleSimulator consoleSimulator = mock(ConsoleSimulator.class);
        User user = mock(User.class);
        PostLoginMenu postLoginMenu = new PostLoginMenu(library, consoleSimulator, user);
        when(consoleSimulator.scanOption()).thenReturn(5);

        postLoginMenu.displayPostLoginMenu();

        verify(consoleSimulator, times(1)).display("\nMENU:\n\n1. Checkout book.\n2. Return book.\n3. Checkout movie\n4. View my details.\n5. Go back.\n\nEnter your choice : ");
    }

    @Test
    public void testShouldNotifyOnChoosingInvalidOption() {
        Library library = mock(Library.class);
        ConsoleSimulator consoleSimulator = mock(ConsoleSimulator.class);
        User user = mock(User.class);
        PostLoginMenu postLoginMenu = new PostLoginMenu(library, consoleSimulator, user);
        when(consoleSimulator.scanOption()).thenReturn(10);

        postLoginMenu.performPostLoginAction(consoleSimulator.scanOption());

        verify(consoleSimulator, times(1)).display("Please select a valid option!");

    }
}