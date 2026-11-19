package com.LibraryManagementSystem.models;

import com.LibraryManagementSystem.enums.BookStatus;

import java.util.Calendar;
import java.util.Date;

public class BookItem {
    private boolean isReferenceOnly;
    private Date borrowed;
    private Date dueDate;
    private Double price;
    private BookStatus status;
    private Date dateOfPurchase;
    private Rack placedAt;
    private Book book;


    public BookItem(boolean isReferenceOnly, double price, Date dateOfPurchase, Book book) {
        this.isReferenceOnly = isReferenceOnly;
        this.price = price;
        this.dateOfPurchase = dateOfPurchase;
        this.book = book;
    }

    public void checkout(Member member){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, 15);

        member.incrementTotalBooksCheckedout();
        setPlacedAt(null);
        setStatus(BookStatus.ISSUED);
        setBorrowedDate(new Date());
        setDueDate(calendar.getTime());
    }

    public void setBorrowedDate(Date date) {
        this.borrowed = date;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setRack(Rack rack) {
        this.placedAt = rack;
    }

    public Rack getRack() {
        return placedAt;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public Book getBook() {
        return book;
    }

    public boolean isBookAvailable() {
        return !isReferenceOnly && status == BookStatus.AVAILABLE;
    }

    private void setPlacedAt(Rack placedAt) {
        this.placedAt = placedAt;
    }
}
