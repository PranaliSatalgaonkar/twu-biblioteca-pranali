package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticatorTest {

    @Test
    public void testShouldValidateLibraryNumberAndPassword() {
        Authenticator authenticator = new Authenticator();
        User user = new User("123-4567", "abcd");

        assertTrue(authenticator.login(user));
    }

    @Test
    public void testShouldReturnFalseIfUserDoesnotExist() {
        Authenticator authenticator = new Authenticator();
        User user = new User("123-4567", "abce");

        assertFalse(authenticator.login(user));
    }
}