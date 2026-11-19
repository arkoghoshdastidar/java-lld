package com.LibraryManagementSystem.models;

import com.LibraryManagementSystem.enums.BookFormat;

import java.util.Date;
import java.util.List;

public class Book {
    private String ISBN;
    private String title;
    private String subject;
    private String publisher;
    private Date publicationDate;
    private String language;
    private Integer numberOfPages;
    private BookFormat format;
    private List<Author> authors;

    private Book() {
    }

    private Book(Builder builder) {
        this.ISBN = builder.ISBN;
        this.title = builder.title;
        this.subject = builder.subject;
        this.publisher = builder.publisher;
        this.publicationDate = builder.publicationDate;
        this.language = builder.language;
        this.numberOfPages = builder.numberOfPages;
        this.format = builder.format;
        this.authors = builder.authors;
    }

    public static class Builder {
        private String ISBN;
        private String title;
        private String subject;
        private String publisher;
        private Date publicationDate;
        private String language;
        private Integer numberOfPages;
        private BookFormat format;
        private List<Author> authors;

        public Builder(final String ISBN, final String title) {
            this.ISBN = ISBN;
            this.title = title;
        }

        public Builder setSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder setPublisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        public Builder setPublicationDate(Date date) {
            this.publicationDate = date;
            return this;
        }

        public Builder setLanguage(String language) {
            this.language = language;
            return this;
        }

        public Builder setNumberOfPages(Integer numberOfPages) {
            this.numberOfPages = numberOfPages;
            return this;
        }

        public Builder setBookFormat(BookFormat format) {
            this.format = format;
            return this;
        }

        public Builder setAuthors(List<Author> authors) {
            this.authors = authors;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }

    public String getTitle() {
        return title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public String getSubject() {
        return subject;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public String getBookDetails() {
        return "Title: " + title + "\nSubject: " + subject + "\nPublisher: " + publisher + "\nPublication Date: " + publicationDate;
    }
}
