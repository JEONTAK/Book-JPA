package com.example.bookjpa.author.dto;

import java.util.List;
import lombok.Getter;

@Getter
public class AuthorRequest {

    private final String name;
    private final List<Long> books;

    private AuthorRequest(String name, List<Long> books) {
        this.name = name;
        this.books = books;
    }
}
