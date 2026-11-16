package com.LibraryManagementSystem.models;

import com.LibraryManagementSystem.datatypes.Address;

public class Author extends Person {
    public Author(String name, String email, String phone, Address address) {
        super(name, email, phone, address);
    }
}
