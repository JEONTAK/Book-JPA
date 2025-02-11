package com.example.bookjpa.author.dto;

import lombok.Getter;

@Getter
public class AuthorRequest {

    private final String name;

    private AuthorRequest(String name) {
        this.name = name;
    }

}
