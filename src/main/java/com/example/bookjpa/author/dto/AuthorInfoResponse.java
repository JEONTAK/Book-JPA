package com.example.bookjpa.author.dto;

import com.example.bookjpa.author.entity.Author;
import lombok.Getter;

@Getter
public class AuthorInfoResponse {

    private final Long id;
    private final String name;

    private AuthorInfoResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static AuthorInfoResponse of(Author author) {
        return new AuthorInfoResponse(author.getId(), author.getName());
    }
}
