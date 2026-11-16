package com.LibraryManagementSystem.notification;

import com.LibraryManagementSystem.enums.NotificationType;

public class NotificationAdapter {
    public static Notification getNotificationObject(NotificationType type, String ID, String content) throws IllegalArgumentException {
        if (type == null) {
            throw new IllegalArgumentException("Notification type cannot be null");
        }
        Notification notificationObj = null;
        switch(type) {
            case NotificationType.POSTAL:
                notificationObj = new PostalNotification(ID, content);
                break;
            case NotificationType.EMAIL:
                notificationObj = new EmailNotification(ID, content);
                break;
            default:
                throw new IllegalArgumentException("Notification type " + type + " is not supporter");
        }
        return notificationObj;
    }
}
