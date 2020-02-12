package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticatorTest {

    @Test
    public void testShouldValidateLibraryNumberAndPassword() {
        Authenticator authenticator = new Authenticator();

        assertTrue(authenticator.login("123-4567", "abcd"));
    }

    @Test
    public void testShouldReturnFalseIfUserDoesNotExist() {
        Authenticator authenticator = new Authenticator();

        assertFalse(authenticator.login("123-4567", "abce"));
    }

    @Test
    public void testShouldReturnCurrentUser() {
        Authenticator authenticator = new Authenticator();
        User user = new User("111-1111", "1111", "User2", "user2@gmail.com", "9999999999");

        assertEquals(user, authenticator.retrieveCurrentUser("111-1111", "1111"));
    }
}