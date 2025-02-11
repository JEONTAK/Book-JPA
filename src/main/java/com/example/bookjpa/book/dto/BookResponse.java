package com.example.bookjpa.book.dto;

import com.example.bookjpa.author.dto.AuthorInfoResponse;
import com.example.bookjpa.book.entity.Book;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;

@Getter
public class BookResponse {

    private final Long id;
    private final String title;
    private final List<AuthorInfoResponse> authors;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    private BookResponse(Long id, String title, List<AuthorInfoResponse> authors,
                         LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public static BookResponse of(Book book, List<AuthorInfoResponse> authors) {
        return new BookResponse(book.getId(), book.getTitle(), authors, book.getCreatedAt(),
                book.getModifiedAt());
    }
}
