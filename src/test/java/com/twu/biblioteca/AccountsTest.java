package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountsTest {

    @Test
    public void testShouldValidateLibraryNumberAndPassword() {
        Accounts accounts = new Accounts();
        User user = new User("123-4567", "abcd");

        assertTrue(accounts.validate(user));
    }
}