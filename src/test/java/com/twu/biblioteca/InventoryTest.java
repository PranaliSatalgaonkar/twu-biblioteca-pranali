package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    @Test
    public void testShouldCheckIfBookIsPresentInInventory() {
        Inventory inventory = new Inventory();
        Book book = new Book("Little Women", "Louisa May Alcott", 1868);

        assertTrue(inventory.isInInventory(book));
    }

    @Test
    public void testShouldCheckIfBookIsAbsentInInventory() {
        Inventory inventory = new Inventory();
        Book book = new Book("The Spy", "Paulo Coelho", 2016);

        assertFalse(inventory.isInInventory(book));
    }
}