package com.vinsguru.sec03;

import com.vinsguru.model.sec03.Book;
import com.vinsguru.model.sec03.Library;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;

public class Lec05Collection {
    private static final Logger logger = LoggerFactory.getLogger(Lec05Collection.class);

    public static void main(String[] args) {
        var book1 = Book.newBuilder()
                .setTitle("Harry Potter - part 1")
                .setAuthor("JK Rowling")
                .setPublicationYear(1997)
                .build();

        var book2 = book1.toBuilder()
                .setTitle("Harry Potter - part 2").setPublicationYear(1998).build();

        var book3 = book1.toBuilder()
                .setTitle("Harry Potter - part 3").setPublicationYear(1999).build();

        var library = Library.newBuilder()
                .setName("Fantasy Library")
//                .addBooks(book1).addBooks(book2).addBooks(book3)
                .addAllBooks(List.of(book1, book2, book3))
//                .addAllBooks(Set.of(book1, book2, book3))   // for Set of unique items
                .build();

        logger.info("library {}", library);

    }

}