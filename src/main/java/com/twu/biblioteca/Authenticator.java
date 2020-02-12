package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Authenticator {
    private List<User> registeredUsersList;

    Authenticator() {
        registeredUsersList = new ArrayList<>(Arrays.asList(new User("123-4567", "abcd"),
                new User("111-1111", "1111"),
                new User("123-9842", "pass123"),
                new User("158-0106", "password"),
                new User("787-5008", "xyz123")));
    }

    public boolean login(User user) {
        for(User registeredUser : registeredUsersList){
            if(registeredUser.getLibraryNumber().equals(user.getLibraryNumber()) && registeredUser.getPassword().equals(user.getPassword()))
                return true;
        }
        return false;
    }
}
