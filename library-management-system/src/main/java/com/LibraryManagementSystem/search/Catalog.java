package com.LibraryManagementSystem.search;

import java.util.Date;
import java.util.List;

import com.LibraryManagementSystem.models.Author;
import com.LibraryManagementSystem.models.BookItem;

public class Catalog implements Search {
    private static Catalog instance;
    private List<BookItem> books;

    private Catalog(List<BookItem> books) {
        this.books = books;
    }

    public static Catalog getInstance(List<BookItem> books) {
        if(instance == null) {
            instance = new Catalog(books);
        }
        return instance;
    }

    @Override
    public BookItem searchByTitle(String title) throws Error {
        if(books.isEmpty()) {
            throw new Error("The catalog is empty, no books found");
        }

        return books.stream().filter((BookItem book) ->
                book.getBook().getTitle().equals(title) && book.isBookAvailable()
        ).findFirst().orElse(null);
    }

    @Override
    public BookItem searchByAuthor(String authorName) throws Error {
        if(books.isEmpty()) {
            throw new Error("The catalog is empty, no books found");
        }

        return books.stream().filter(
                (BookItem book) -> book.getBook().getAuthors().stream().anyMatch((Author author) -> author.getName().equalsIgnoreCase(authorName))
        ).findFirst().orElse(null);
    }

    @Override
    public BookItem searchBySubject(String subject) throws Error {
        if(books.isEmpty()) {
            throw new Error("The catalog is empty, no books found");
        }

        return books.stream().filter(
                (BookItem book) -> book.getBook().getSubject().equalsIgnoreCase(subject) && book.isBookAvailable()
        ).findFirst().orElse(null);
    }

    @Override
    public BookItem searchByPublicationDate(Date startDate, Date endDate) {
        if(books.isEmpty()) {
            throw new Error("The catalog is empty, no books found");
        }

        return books.stream().filter(
                (BookItem book) -> book.getBook().getPublicationDate().after(startDate) && book.getBook().getPublicationDate().before(endDate)
        ).findFirst().orElse(null);
    }
}
