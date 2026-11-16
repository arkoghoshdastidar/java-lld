package com.LibraryManagementSystem.models;

public class Librarian extends User {


    public Librarian(int ID, String password) {
        super(ID, password);
    }

    @Override
    public boolean resetPassword(String password) {
        this.password = password;
        return true;
    }

    public boolean addBookItem(BookItem bookItem) {
        return true;
    }

    public boolean blockMember(Member memeber) {
        return true;
    }

    public boolean unBlockMember(Member member) {
        return true;
    }
}