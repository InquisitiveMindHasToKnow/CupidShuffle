package com.example.cupidshuffle.model;

public class PrivateMessages {
    private String sender;
    private String message;

    public PrivateMessages(String sender, String message) {
        this.sender = sender;
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }
}
