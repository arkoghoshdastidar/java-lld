package com.LibraryManagementSystem.models;

import java.util.Date;

public class LibraryCard {
    private String cardNumber;
    private boolean active;
    private Date issued;

    public LibraryCard(String cardNumber) {
        this.cardNumber = cardNumber;
        this.active = true;
        issued = new Date();
    }
}