package com.parkinglot.account;

import com.parkinglot.enums.AccountStatus;
import com.parkinglot.models.Person;

public class Account {
    private String username;
    private String password;
    private AccountStatus status;
    private Person person;

    public Account(String username, String password, Person person) {
        this.username = username;
        this.password = password;
        this.person = person;
        status = AccountStatus.ACTIVE;
    }
}