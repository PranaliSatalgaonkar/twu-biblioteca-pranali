package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void testShouldReturnUserLibraryNumber() {
        User user = new User("999-9999", "pqrs", "User", "user@gmail.com", "1234567890");

        assertEquals("999-9999", user.getLibraryNumber());
    }

    @Test
    public void testShouldReturnUserPassword() {
        User user = new User("999-9999", "pqrs", "User", "user@gmail.com", "1234567890");

        assertEquals("pqrs", user.getPassword());
    }

    @Test
    public void testShouldReturnUserInformation() {
        User user = new User("999-9999", "pqrs", "User", "user@gmail.com", "1234567890");
        String expectedOutput = "User user@gmail.com 1234567890";

        assertEquals(expectedOutput, user.getUserInformation());
    }
}