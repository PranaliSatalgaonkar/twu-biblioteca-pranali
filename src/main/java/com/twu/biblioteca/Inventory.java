package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public class Inventory {
    ArrayList<Book> inventoryBookList; //TODO; private, List instead of arraylist

    public Inventory() {
        inventoryBookList = new ArrayList<>(Arrays.asList(new Book("Pride and Prejudice", "Jane Austen", 1813),
                new Book("The Diary of a Young Girl", "Anne Frank", 1947),
                new Book("To Kill a Mockingbird", "Harper Lee", 1960),
                new Book("Little Women", "Louisa May Alcott", 1868),
                new Book("The Alchemist", "Paulo Coelho", 1988))); //TODO no need for arraylist
    }

    public boolean isInInventory(Book book) {
        return inventoryBookList.contains(book);
    }
}
