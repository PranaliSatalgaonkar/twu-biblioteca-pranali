package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class MenuTest {

    @Test
    public void testShouldCallMenu() {
        Library library = mock(Library.class);
        Menu menu = new Menu();

        menu.displayMenu(library);

        verify(library, times(1)).displayBookList();
    }

}