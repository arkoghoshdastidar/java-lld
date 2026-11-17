package com.LibraryManagementSystem.search;

import com.LibraryManagementSystem.models.BookItem;
import java.util.Date;

public interface Search {
    BookItem searchByTitle(String title);
    BookItem searchByAuthor(String author);
    BookItem searchBySubject(String subject);
    BookItem searchByPublicationDate(Date startDate, Date endDate);
}
