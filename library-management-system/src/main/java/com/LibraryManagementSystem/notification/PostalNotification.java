package com.LibraryManagementSystem.notification;

import com.LibraryManagementSystem.datatypes.Address;

public class PostalNotification extends Notification {
    private Address address;

    public PostalNotification(String ID, String content) {
        super(ID, content);
    }

    @Override
    public void send() {
        if(address == null) {
            System.out.println("Failed to send postal notification as address is missing");
            return;
        }

        System.out.println("Sending post to " + address.getAddressString());
        System.out.println(getContent());
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
