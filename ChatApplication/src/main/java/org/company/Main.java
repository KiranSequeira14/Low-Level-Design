package org.company;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        User user1 = new User("Kiran Sequeira");
        User user2 = new User("Raj");
        User user3 = new User("Samson");

        //Personal chat -> having exactly 2 people
        Channel personalChat = new Channel(Arrays.asList(new User[]{user1, user2}));
        Message message = new Message("Hiii, this is my first message", user1);
        personalChat.postMessage(message);
        personalChat.deleteMessage(message);

        List<User> group = Arrays.asList(new User[]{user1, user2, user3});
        GroupChat groupChat = new GroupChat(group);
        Message message2 = new Message("Yoo, user3 here!!!", user3);
        groupChat.postMessage(message);
        groupChat.postMessage(message2);
        groupChat.deleteMessage(message2);
        groupChat.removeUser(user2.getUserId());
    }
}