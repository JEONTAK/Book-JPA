package com.example.bookjpa.book.dto;

import java.util.List;
import lombok.Getter;

@Getter
public class BookRequest {

    private final String title;
    private final List<Long> authors;

    private BookRequest(String title, List<Long> authors) {
        this.title = title;
        this.authors = authors;
    }
}