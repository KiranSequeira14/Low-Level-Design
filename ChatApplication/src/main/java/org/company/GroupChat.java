package org.company;

import java.util.List;

public class GroupChat extends Channel {

    public GroupChat(List<User> users) {
        super(users);
    }

    public void removeUser(String userId) {
        this.getUsers().remove(userId);
        System.out.println("User with id " + userId + " has been removed");
    }
}
