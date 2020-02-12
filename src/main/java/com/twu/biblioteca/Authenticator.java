package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Authenticator {
    private List<User> registeredUsersList;

    Authenticator() {
        registeredUsersList = new ArrayList<>(Arrays.asList(new User("123-4567", "abcd", "User", "user@gmail.com", "1234567890"),
                new User("111-1111", "1111", "User2", "user2@gmail.com", "9999999999"),
                new User("123-9842", "pass123", "User3", "user3@gmail.com", "8888888888"),
                new User("158-0106", "password", "User4", "user4@gmail.com", "7777777777"),
                new User("787-5008", "xyz123", "User5", "user5@gmail.com", "6666666666")));
    }

    public boolean login(String libraryNumber, String password) {
        for(User registeredUser : registeredUsersList){
            if(registeredUser.getLibraryNumber().equals(libraryNumber) && registeredUser.getPassword().equals(password))
                return true;
        }
        return false;
    }
}
