package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LibraryTest {

    @Test
    public void testShouldDisplayBookList() {
        ConsoleSimulator consoleSimulator = mock(ConsoleSimulator.class);
        Library library = new Library(consoleSimulator);

        library.displayBookList();

        verify(consoleSimulator, times(1)).display("Pride and Prejudice Jane Austen 1813");
        verify(consoleSimulator, times(1)).display("The Diary of a Young Girl Anne Frank 1947");
        verify(consoleSimulator, times(1)).display("To Kill a Mockingbird Harper Lee 1960");
        verify(consoleSimulator, times(1)).display("Little Women Louisa May Alcott 1868");
        verify(consoleSimulator, times(1)).display("The Alchemist Paulo Coelho 1988");
    }

    @Test
    public void testShouldCheckoutABookOnlyIfUserIsLoggedIn() {
        ConsoleSimulator consoleSimulator = mock(ConsoleSimulator.class);
        Library library = new Library(consoleSimulator);
        when(consoleSimulator.scanLibraryNumber()).thenReturn("123-4567");
        when(consoleSimulator.scanPassword()).thenReturn("abcd");

        library.checkout(new Book("Pride and Prejudice", "Jane Austen", 1813));
        library.checkout(new Book("Pride and Prejudice", "Jane Austen", 1813));

        verify(consoleSimulator, times(1)).display("Thank you! Enjoy the book");
        verify(consoleSimulator, times(1)).display("Sorry, that book is not available");
    }

    @Test
    public void testShouldNotifyOnSuccessfulCheckoutOfBook() {
        ConsoleSimulator consoleSimulator = mock(ConsoleSimulator.class);
        Library library = new Library(consoleSimulator);
        when(consoleSimulator.scanLibraryNumber()).thenReturn("123-4567");
        when(consoleSimulator.scanPassword()).thenReturn("abcd");

        library.checkout(new Book("The Diary of a Young Girl", "Anne Frank", 1947));

        verify(consoleSimulator, times(1)).display("Thank you! Enjoy the book");
    }

    @Test
    public void testShouldNotifyOnUnsuccessfulCheckoutOfBook() {
        ConsoleSimulator consoleSimulator = mock(ConsoleSimulator.class);
        Library library = new Library(consoleSimulator);
        when(consoleSimulator.scanLibraryNumber()).thenReturn("123-4567");
        when(consoleSimulator.scanPassword()).thenReturn("abcd");

        library.checkout(new Book("The Secret Seven", "Enid Blyton", 1949));

        verify(consoleSimulator, times(1)).display("Sorry, that book is not available");
    }

    @Test
    public void testShouldReturnABookOnlyIfUserIsLoggedIn() {
        ConsoleSimulator consoleSimulator = mock(ConsoleSimulator.class);
        Library library = new Library(consoleSimulator);
        when(consoleSimulator.scanLibraryNumber()).thenReturn("123-4567");
        when(consoleSimulator.scanPassword()).thenReturn("abcd");

        Book book = new Book("The Alchemist", "Paulo Coelho", 1988);
        library.returnBook(book);

        assertTrue(library.bookList.contains(book));
    }

    @Test
    public void testShouldNotifyOnSuccessfulReturnOfBook() {
        ConsoleSimulator consoleSimulator = mock(ConsoleSimulator.class);
        Library library = new Library(consoleSimulator);
        when(consoleSimulator.scanLibraryNumber()).thenReturn("123-4567");
        when(consoleSimulator.scanPassword()).thenReturn("abcd");

        library.returnBook(new Book("The Alchemist", "Paulo Coelho", 1988));

        verify(consoleSimulator, times(1)).display("Thank you for returning the book");
    }

    @Test
    public void testShouldNotifyOnUnsuccessfulReturnOfBook() {
        ConsoleSimulator consoleSimulator = mock(ConsoleSimulator.class);
        Library library = new Library(consoleSimulator);
        when(consoleSimulator.scanLibraryNumber()).thenReturn("123-4567");
        when(consoleSimulator.scanPassword()).thenReturn("abcd");

        library.returnBook(new Book("Alchemist", "Paulo Coelho", 1988));

        verify(consoleSimulator, times(1)).display("That is not a valid book to return");
    }

    @Test
    public void testShouldDisplayMovieList() {
        ConsoleSimulator consoleSimulator = mock(ConsoleSimulator.class);
        Library library = new Library(consoleSimulator);

        library.displayMovieList();

        verify(consoleSimulator, times(1)).display("Parasite 2019 Bong Joon-ho 10");
        verify(consoleSimulator, times(1)).display("The Irishman 2019 Martin Scorsese 7");
        verify(consoleSimulator, times(1)).display("Booksmart 2019 Olivia Wilde 7");
        verify(consoleSimulator, times(1)).display("The Farewell 2019 Lulu Wang 8");
        verify(consoleSimulator, times(1)).display("Knives Out 2019 Rian Johnson unrated");
    }

    @Test
    public void testShouldCheckoutAMovie() {
        ConsoleSimulator consoleSimulator = mock(ConsoleSimulator.class);
        Library library = new Library(consoleSimulator);

        library.checkout(new Movie("The Farewell", 2019, "Lulu Wang", "8"));

        verify(consoleSimulator, times(1)).display("Thank you! Enjoy the movie");
    }

    @Test
    public void testShouldNotifyOnUnsuccessfulCheckoutOfMovie() {
        ConsoleSimulator consoleSimulator = mock(ConsoleSimulator.class);
        Library library = new Library(consoleSimulator);

        library.checkout(new Movie("The Farewell", 2019, "Wang", "8"));

        verify(consoleSimulator, times(1)).display("Sorry, that movie is not available");
    }

    @Test
    public void testShouldNotifyOnUnsuccessfulLoginWhileCheckingOutABook() {
        ConsoleSimulator consoleSimulator = mock(ConsoleSimulator.class);
        Library library = new Library(consoleSimulator);
        when(consoleSimulator.scanLibraryNumber()).thenReturn("123-4567");
        when(consoleSimulator.scanPassword()).thenReturn("abcde");

        library.checkout(new Book("Pride and Prejudice", "Jane Austen", 1813));

        verify(consoleSimulator, times(1)).display("Invalid credentials");
    }

    @Test
    public void testShouldNotifyOnUnsuccessfulLoginWhileReturningABook() {
        ConsoleSimulator consoleSimulator = mock(ConsoleSimulator.class);
        Library library = new Library(consoleSimulator);
        when(consoleSimulator.scanLibraryNumber()).thenReturn("123-4567");
        when(consoleSimulator.scanPassword()).thenReturn("abcde");

        library.returnBook(new Book("Pride and Prejudice", "Jane Austen", 1813));

        verify(consoleSimulator, times(1)).display("Invalid credentials");
    }
}
