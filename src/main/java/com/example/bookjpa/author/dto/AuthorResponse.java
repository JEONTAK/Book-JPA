package com.example.bookjpa.author.dto;

import com.example.bookjpa.author.entity.Author;
import com.example.bookjpa.book.dto.BookInfoResponse;
import java.util.List;
import lombok.Getter;

@Getter
public class AuthorResponse {

    private final Long id;
    private final String name;
    private final List<BookInfoResponse> books;

    private AuthorResponse(Long id, String name, List<BookInfoResponse> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }

    public static AuthorResponse of(Author author, List<BookInfoResponse> books) {
        return new AuthorResponse(author.getId(), author.getName(), books);
    }
}
