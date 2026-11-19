package com.LibraryManagementSystem.models;

import com.LibraryManagementSystem.enums.AccountStatus;

abstract public class User {
    private int ID;
    private AccountStatus accountStatus;
    private Person person;
    private LibraryCard libraryCard;
    protected String password;

    public User(int ID, String password) {
        this.ID = ID;
        this.password = password;
        this.accountStatus = AccountStatus.ACTIVE;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setLibraryCard(LibraryCard libraryCard) {
        this.libraryCard = libraryCard;
    }

    public String getName() {
        return person.getName();
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public abstract boolean resetPassword(String password);
}