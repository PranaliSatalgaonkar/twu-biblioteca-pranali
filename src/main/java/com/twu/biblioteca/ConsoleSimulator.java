package com.twu.biblioteca;

import java.util.Scanner;

//TODO: tests
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

    public void display(String message){
        System.out.println(message);
    }
}