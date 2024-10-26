package com.library.management.bookservice.Service;

import com.library.management.bookservice.Model.Book;
import com.library.management.bookservice.Repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    /* private -> BookRepository is only accessible within BookService
       final -> bookRepository is FINAL - no changes will be done
     */
    private final BookRepository bookRepository;


    /* creating a constructor and injecting the BookRepository
       interface so that we can use it to preform database operations
     */
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    // adding a new book to the database
    public Book addingBook(Book book) {
        return bookRepository.save(book);
    }

    // getting all the books from the database
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    /* getting a specific book from the database with unique Id
     -> we use Optional here because we are fetching an Id which is
     supposed to be unique: either we get the Id/book or not
     */
    public Optional<Book> findingBookById(Long id) {
        return bookRepository.findById(id);
    }

    // searching for a specific book by the name of its author
    public List<Book> findingBookByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    // searching for a specific book by its title
    public List<Book> findingBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    // a certain book is found by Id - which then gets deleted
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
