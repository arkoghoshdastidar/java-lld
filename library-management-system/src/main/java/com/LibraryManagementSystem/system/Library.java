package com.LibraryManagementSystem.system;

import com.LibraryManagementSystem.datatypes.Address;
import com.LibraryManagementSystem.search.Catalog;
import com.LibraryManagementSystem.transactions.BookLending;
import com.LibraryManagementSystem.transactions.BookReservation;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private static String name;
    private static Address address;
    private static Catalog catalog;
    private static Library instance;
    private static List<BookReservation> reservations;
    private static List<BookLending> orders;

    private Library(String name, Address address) {
        Library.name = name;
        Library.address = address;
        reservations = new ArrayList<>();
        orders = new ArrayList<>();
    }

    public static Library getInstance(String name, Address address) {
        synchronized(Library.class) {
            if(Library.instance == null) {
                instance = new Library(name, address);
            }
        }

        return instance;
    }

    public Address getAddress() {
        return Library.address;
    }

    public Catalog getCatalog() {
        return Library.catalog;
    }

    public Catalog setCatalog(Catalog catalog) {
        Library.catalog = catalog;
        return catalog;
    }

    public String getName() {
        return name;
    }
}
