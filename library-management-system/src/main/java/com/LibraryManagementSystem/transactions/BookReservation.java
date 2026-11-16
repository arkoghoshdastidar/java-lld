package com.LibraryManagementSystem.transactions;

import com.LibraryManagementSystem.enums.ReservationStatus;
import com.LibraryManagementSystem.models.BookItem;
import com.LibraryManagementSystem.models.Member;

import java.util.Date;

public class BookReservation {
    private Integer ID;
    private BookItem bookItem;
    private Member member;
    private ReservationStatus status;
    private Date date;

    public void BookReservation(Integer ID, BookItem bookItem, Member member) {
        this.ID = ID;
        this.bookItem = bookItem;
        this.member = member;
        this.status = ReservationStatus.PENDING;
        this.date = new Date();
    }

    public ReservationStatus getStatus() {
        return this.status;
    }
}
