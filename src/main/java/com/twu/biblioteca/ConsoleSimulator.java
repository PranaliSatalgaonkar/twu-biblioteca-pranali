package com.twu.biblioteca;

import java.util.Scanner;

public class ConsoleSimulator {
    private Scanner scanner = new Scanner(System.in);

    public int scanOption() {
        return scanner.nextInt();
    }

    public String scanBookTitle() {
        return scanner.nextLine();
    }

    public String scanBookAuthor() {
        return scanner.nextLine();
    }

    public int scanBookPublicationYear() {
        return scanner.nextInt();
    }

    public void scanBlankLine() {
        scanner.nextLine();
    }

    public String scanLibraryNumber() {
        return scanner.next();
    }

    public String scanPassword() {
        return scanner.next();
    }

    public String scanMovieName() {
        return scanner.nextLine();
    }

    public int scanMovieReleaseYear() {
        return scanner.nextInt();
    }

    public String scanMovieDirector() {
        return scanner.nextLine();
    }

    public int scanMovieRating() {
        return scanner.nextInt();
    }

    public void display(String message) {
        System.out.println(message);
    }
}
