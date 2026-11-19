package com.LibraryManagementSystem.system;

import com.LibraryManagementSystem.enums.AccountStatus;
import com.LibraryManagementSystem.datatypes.Address;
import com.LibraryManagementSystem.models.BookItem;
import com.LibraryManagementSystem.models.Member;
import com.LibraryManagementSystem.enums.ReservationStatus;
import com.LibraryManagementSystem.search.Catalog;
import com.LibraryManagementSystem.transactions.BookLending;
import com.LibraryManagementSystem.transactions.BookReservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public boolean checkoutBook(BookItem bookItem, Member member) {
        if(member.getAccountStatus() == AccountStatus.BLACKLISTED || member.getAccountStatus() == AccountStatus.CLOSED) {
            System.out.println("The account is banned or closed");
            return false;
        }else if(member.getTotalBooksCheckedout() > 1) {
            System.out.println("The user can only checkout one book at a time");
            return false;
        }

        Optional<BookReservation> isBookAlreadyReservedByTheUser = reservations.stream().filter(
                r -> r.getMember().getName().equalsIgnoreCase(member.getName()) && r.getStatus() == ReservationStatus.PENDING
        ).findAny();

        if(isBookAlreadyReservedByTheUser.isPresent()) {
            System.out.println("The book " + bookItem.getBook().getBookDetails() + " is already reserved by the user");
            return false;
        }

        BookLending order = new BookLending(orders.size() + 1, member, bookItem);

        orders.add(order);

        return true;
    }
}
