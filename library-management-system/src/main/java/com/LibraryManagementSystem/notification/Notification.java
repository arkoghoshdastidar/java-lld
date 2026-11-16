package com.LibraryManagementSystem.notification;
import java.util.Date;

abstract public class Notification {
    private String ID;
    private String content;

    public Notification(String id, String content) {
        this.ID = ID;
        this.content = content;
    }

    abstract public void send();

    String getContent() {
        return this.content;
    }
}
