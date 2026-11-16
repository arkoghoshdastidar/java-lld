package com.LibraryManagementSystem.transactions;

import com.LibraryManagementSystem.models.BookItem;
import com.LibraryManagementSystem.models.Member;

import java.util.Calendar;
import java.util.Date;

public class BookLending {
    private String ID;
    private Date creationDate;
    private Date returnDate;
    private Date dueDate;
    private Member member;
    private BookItem book;

    public void BookLending(String ID, Member member, BookItem bookItem) {
        this.ID = ID;
        this.member = member;
        this.book = bookItem;
        this.creationDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, 15);
        this.dueDate = calendar.getTime();
    }

    public boolean reviseDueDate(Date date) {
        if(this.dueDate.after(date)) {
            return false;
        }
        this.dueDate = date;
        return true;
    }
}
