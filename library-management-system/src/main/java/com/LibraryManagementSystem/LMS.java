package com.LibraryManagementSystem;

import com.LibraryManagementSystem.datatypes.Address;
import com.LibraryManagementSystem.enums.BookStatus;
import com.LibraryManagementSystem.models.Member;
import com.LibraryManagementSystem.models.Author;
import com.LibraryManagementSystem.models.Rack;
import com.LibraryManagementSystem.models.Book;
import com.LibraryManagementSystem.models.BookItem;
import com.LibraryManagementSystem.search.Catalog;
import com.LibraryManagementSystem.system.Library;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class LMS {
    public static void main(String[] args) {
        System.out.println("\n================= Starting Library Management System ================");

        String libraryName = "HSR Layout Library";
        Address libraryAddress = new Address.Builder("21st Main Road, 15th Cross Road, HSR Sector 1").setCity("Bengaluru").setState("Karnataka").setZipCode(831001).setCountry("IN").build();

        Library library = Library.getInstance(libraryName, libraryAddress);

        System.out.println("New Library : " + library.getName() + "\nAddress : " + library.getAddress().getAddressString());

        List<Author> authors = List.of(
                new Author("Reddy", "reddy@gmail.com", "1111-1111-11", new Address.Builder("Mumbai").build()),
                new Author("Not Reddy", "not-reddy@gmail.com", "2222-2222-22", new Address.Builder("Pondicherry").build()),
                new Author("Get Reddy", "get-reddy@gmail.com", "3333-3333-33", new Address.Builder("Dehradun").build())
        );

        List<String> ISBNs = List.of("112211", "221122","221121");
        List<String> titles = List.of("DSA", "LLD", "HLD");
        List<String> subjects = List.of("Problem Solving", "Low Level Design", "High Level Design");
        List<String> publishers = List.of("Narshima Karamunchi", "Head First Design Patterns", "Martin Klepmann");

        List<BookItem> books = new ArrayList<>();
        List<Rack> racks = new ArrayList<>();

        for(int i=0; i<15; i++) {
            int idx = ((int)(Math.random()*100))%3;

            Book book = new Book.Builder(ISBNs.get(idx), titles.get(idx))
                    .setTitle(titles.get(idx))
                    .setSubject(subjects.get(idx))
                    .setPublisher(publishers.get(idx))
                    .setPublicationDate(new Date())
                    .setAuthors(List.of(authors.get(idx)))
                    .build();
            Rack bookRack = new Rack("rack_no-"+i);

            BookItem bookItem = new BookItem(false, idx+10, new Date(), book);
            bookItem.setStatus(BookStatus.AVAILABLE);
            bookItem.setRack(bookRack);

            books.add(bookItem);
            racks.add(bookRack);
        }

        Catalog catalog = Catalog.getInstance(books);
        library.setCatalog(catalog);

         Member member1 = new Member(1, "agd_014");
         Member member2 = new Member(2, "suraj_007");
         Member member3 = new Member(3, "mac_mohan");

         System.out.println("\nMember1 is searching the catalog for a book with title - DSA\n");

         BookItem searchedBook = library.getCatalog().searchByTitle("DSA");

         if(searchedBook != null) {
             System.out.println("Book Found");
             System.out.println(searchedBook.getBook().getBookDetails());
             System.out.println("Member1 is booking the searched book");
             boolean orderPlaced = library.checkoutBook(searchedBook, member1);

             if(orderPlaced) {
                 System.out.println("Order placed for book: " + searchedBook.getBook().getBookDetails() + " successfully - " + "Member1");
             }else {
                 System.out.println("Failed to place order");
             }

         }else{
             System.out.println("Book not found");
         }

         System.out.println("\nMember2 is searching the catalog for a book with subject - Problem Solving\n");
         searchedBook = library.getCatalog().searchBySubject("low level design");

         if(searchedBook != null) {
             System.out.println("Book Found");
             System.out.println(searchedBook.getBook().getBookDetails());
         }else {
             System.out.println("Book not found");
         }



         System.out.println("\n================== Stopping Library Management System ===============");
    }
}
