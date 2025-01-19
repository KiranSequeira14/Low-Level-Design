package org.company;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Channel {
    private static int idCounter = 1;
    final String channelId;
    List<Message> messages;
    Map<String, User> users;

    public Channel() {
        this.channelId = "C" + String.format("%05d", idCounter++);
        messages = new ArrayList<>();
        users = new HashMap<>();
    }

    public Channel(List<User> users) {
        this();
        for (User user : users)
            this.addUser(user);
    }

    public void postMessage(Message message) {
        User sender = message.getSender();
        if (!this.users.containsKey(sender.getUserId())) {
            System.out.println("Sender not in chat");
            return;
        }
        messages.add(message);
    }

    public void deleteMessage(Message message) {
        this.messages = this.messages.stream().filter(cur -> !cur.getMessageId().equals(message.getMessageId())).toList();
    }

    public void addUser(User user) {
        this.users.put(user.getUserId(), user);
    }

}
