package com.library.management.bookservice.Controller;

import com.library.management.bookservice.Model.Book;
import com.library.management.bookservice.Service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    // creating a constructor
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // handling POST requests so that new books can be added
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addingBook(book);
    }

    // handling GET requests so that all books are shown
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    /* handling GET requests so that a specific books is shown based
        on the chosen book-id
    */
    // took slightly longer than I expected, but it works now
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return bookService.findingBookById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /* handling GET requests so that a specific book is shown based
        on the title of the book
    */
    @GetMapping("/search/title")
    public List<Book> findByTitle(@RequestParam String title) {
        return bookService.findingBookByTitle(title);
    }

    /* handling GET requests so that a specific book is shown based
        on the book's author
    */
    @GetMapping("/search/author")
    public List<Book> findByAuthor(@RequestParam String author) {
        return bookService.findingBookByAuthor(author);
    }

    /* handling DELETE requests so that a specific book is deleted from
      the database with the help of its book-id
    */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return ResponseEntity.noContent().build();
    }


}
