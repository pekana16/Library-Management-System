package com.library.management.borrowingservice.Service;

import com.library.management.bookservice.Model.Book;
import com.library.management.bookservice.Service.BookService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BorrowingService {
    private final BookService bookService;

    public BorrowingService(BookService bookService) {
        this.bookService = bookService;
    }

    // calling the markAsBorrowed from BookService
    public Optional<Book> borrowBook(Long id) {
        return bookService.markAsBorrowed(id);
    }


}
