package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    @Test
    public void testShouldCheckIfBookIsPresentInInventory() {
        Inventory inventory = new Inventory();

        assertTrue(inventory.isInInventory(new Book("Little Women", "Louisa May Alcott", 1868)));
    }
}