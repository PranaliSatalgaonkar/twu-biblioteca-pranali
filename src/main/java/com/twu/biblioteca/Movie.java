package com.twu.biblioteca;

import java.util.Objects;

public class Movie {
    protected String name;
    protected int releaseYear;
    protected String director;
    protected String rating;

    public Movie(String name, int releaseYear, String director, String rating) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.director = director;
        this.rating = rating;
    }

    public String getDetails() {
        return name + " " + releaseYear + " " + director + " " + rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return releaseYear == movie.releaseYear &&
                Objects.equals(name, movie.name) &&
                Objects.equals(director, movie.director) &&
                Objects.equals(rating, movie.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, releaseYear, director, rating);
    }
}
