package com.twu.biblioteca;

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
}
