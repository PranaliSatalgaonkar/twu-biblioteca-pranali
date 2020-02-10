package com.twu.biblioteca;

import java.util.Scanner;

//TODO: tests
public class InputScanner {
    Scanner scanner = new Scanner(System.in);//TODO: private

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
}
