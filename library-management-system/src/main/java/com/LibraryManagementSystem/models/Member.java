package com.LibraryManagementSystem.models;

import java.util.Date;

public class Member extends User {
    private Date dateOfMembership;
    private Integer totalBooksCheckedout;

    public Member(int ID, String password) {
        super(ID, password);
        dateOfMembership = new Date();
        totalBooksCheckedout = 0;
    }

    public boolean resetPassword(String password) {
        this.password = password;
        return true;
    }

    public Integer getTotalBooksCheckedout() {
        return totalBooksCheckedout;
    }

    public boolean reserveBookItem(BookItem bookItem) {
        return true;
    }

    public boolean incrementTotalBooksCheckedout() {
        totalBooksCheckedout++;
        return true;
    }

    public boolean checkoutBookItem(BookItem bookItem) {
        return true;
    }

    public boolean returnBookItem(BookItem bookItem) {
        return true;
    }

    public boolean renewBookItem(BookItem bookItem) {
        return true;
    }

    public Integer checkForFine() {
        return 0;
    }
}