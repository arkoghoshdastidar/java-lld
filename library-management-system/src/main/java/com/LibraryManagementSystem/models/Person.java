package com.LibraryManagementSystem.models;

import com.LibraryManagementSystem.datatypes.Address;

public class Person {
    private String name;
    private String email;
    private String phone;
    private Address address;

    public Person(String name, String email, String phone, Address address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
}
