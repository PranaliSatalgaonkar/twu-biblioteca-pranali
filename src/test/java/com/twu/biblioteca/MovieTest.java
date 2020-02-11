package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    @Test
    public void testShouldReturnMovieDetails() {
        Movie movie = new Movie("Parasite", 2019, "Bong Joon-ho", "10");
        String expectedOutput = movie.name + " " + movie.releaseYear + " " + movie.director + " " + movie.rating;

        assertEquals(expectedOutput, movie.getDetails());
    }
}