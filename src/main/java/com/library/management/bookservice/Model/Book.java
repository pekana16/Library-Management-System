package com.library.management.bookservice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Book {

    @Id
    @GeneratedValue
    private Long bookId;
    private String title;
    private String author;
    private boolean isBorrowed = false;

}
