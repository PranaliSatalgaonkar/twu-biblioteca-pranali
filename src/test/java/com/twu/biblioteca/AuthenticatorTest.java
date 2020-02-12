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
    public void testShouldReturnFalseIfUserDoesnotExist() {
        Authenticator authenticator = new Authenticator();

        assertFalse(authenticator.login("123-4567", "abce"));
    }
}