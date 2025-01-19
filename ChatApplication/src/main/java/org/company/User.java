package org.company;

import lombok.Getter;

@Getter
public class User {
    private static int idCounter = 1;
    private final String userId;
    private final String userName;

    public User(String userName) {
        this.userId = "U" + String.format("%05d", idCounter++);
        this.userName = userName;
    }

}
