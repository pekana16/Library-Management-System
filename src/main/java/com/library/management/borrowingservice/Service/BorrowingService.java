package com.library.management.borrowingservice.Service;

import com.library.management.bookservice.Model.Book;
import com.library.management.bookservice.Service.BookService;
import lombok.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class BorrowingService {
    private final RestTemplate restTemplate;


    public BorrowingService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public ResponseEntity<Book> borrowBook(Long id) {
        String bookServiceUrl = "http://localhost:8081";
        String url = bookServiceUrl + "/books/" + id;
        return restTemplate.postForEntity(url, null, Book.class);
    }


}
