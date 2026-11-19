package com.LibraryManagementSystem.models;

import java.util.Date;

public class Member extends User {
    private Date dateOfMembership;
    private int totalBooksCheckedout;

    public Member(int ID, String password) {
        super(ID, password);
        dateOfMembership = new Date();
        totalBooksCheckedout = 0;
    }

    public boolean resetPassword(String password) {
        this.password = password;
        return true;
    }

    public int getTotalBooksCheckedout() {
        return totalBooksCheckedout;
    }

    public boolean incrementTotalBooksCheckedout() {
        totalBooksCheckedout++;
        return true;
    }
}