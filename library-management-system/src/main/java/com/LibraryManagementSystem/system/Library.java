package com.LibraryManagementSystem.system;

import com.LibraryManagementSystem.datatypes.Address;

public class Library {
    private String name;
    private Address address;

    void Library(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}
