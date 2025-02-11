package com.example.bookjpa.author.dto;

import com.example.bookjpa.author.entity.Author;
import com.example.bookjpa.book.dto.BookResponse;
import java.util.List;
import lombok.Getter;

@Getter
public class AuthorResponse {

    private final Long id;
    private final String name;
    private final List<BookResponse> books;

    private AuthorResponse(Long id, String name, List<BookResponse> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }

    public static AuthorResponse of(Author author, List<BookResponse> books) {
        return new AuthorResponse(author.getId(), author.getName(), books);
    }
}
