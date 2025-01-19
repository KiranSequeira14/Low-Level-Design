package org.company;

import lombok.Data;

import java.util.UUID;

@Data
public class Message {
    private String messageId;
    private String content;
    private long timestamp;
    private User sender;

    public Message(String content, User sender) {
        this.messageId = UUID.randomUUID().toString();
        this.content = content;
        this.sender = sender;
        this.timestamp = System.currentTimeMillis();
    }
}
