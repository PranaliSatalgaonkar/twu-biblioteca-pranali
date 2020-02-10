package com.twu.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    public void testShouldReturnBookDetails() {
        Book book = new Book("The Spy", "Paulo Coelho", 2016);
        String expectedOutput = book.title +" "+book.author+" "+book.publicationYear;

        assertEquals(expectedOutput, book.getBookDetails());
    }
}