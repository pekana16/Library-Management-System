package com.library.management.borrowingservice.Controller;


import com.library.management.bookservice.Model.Book;
import com.library.management.borrowingservice.Service.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/borrow")
public class BorrowingController {
    private final BorrowingService borrowingService;

    @Autowired
    public BorrowingController(BorrowingService borrowingService) {
        this.borrowingService = borrowingService;
    }

    /* Handling POST requests so that the book is set to be borrowed
       when the user chooses its id
      -> if the wrong book-id is given, 404 error is shown
    */
    @PostMapping("/{id}")
    public ResponseEntity<Book> markAsBorrowed(@PathVariable Long id) {
        Optional<Book> bookBorrowed = borrowingService.borrowBook(id);
        return bookBorrowed
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
