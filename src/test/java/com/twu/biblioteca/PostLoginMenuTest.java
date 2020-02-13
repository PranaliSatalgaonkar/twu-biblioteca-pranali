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
        when(consoleSimulator.scanOption()).thenReturn(1, 2);

        postLoginMenu.displayPostLoginMenu();

        verify(library, times(1)).checkout((Book) null);
    }

}