package com.LibraryManagementSystem.models;

import com.LibraryManagementSystem.enums.BookStatus;

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

    public boolean checkout(Member member){
        return true;
    }

    public void setBorrowedDateNow(Date date) {
        this.borrowed = date;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setRack(Rack rack) {
        this.placedAt = rack;
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
}
