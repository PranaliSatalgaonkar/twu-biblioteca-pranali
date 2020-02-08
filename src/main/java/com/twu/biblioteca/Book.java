package com.twu.biblioteca;

public class Book {
    protected final String title;
    protected final String author;
    protected final int publicationYear;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getBookDetails(){
        return (title + " " + author + " " + publicationYear);
    }
}
