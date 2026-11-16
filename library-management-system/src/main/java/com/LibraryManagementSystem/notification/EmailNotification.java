package com.LibraryManagementSystem.notification;

public class EmailNotification extends Notification {
    private String email;
    public EmailNotification(String ID, String content) {
        super(ID, content);
    }

    @Override
    public void send() {
        if(email == null) {
            System.out.println("Failed to send email notification as email is missing");
            return;
        }

        System.out.println("Sending email notification...");
        System.out.println(getContent());
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
