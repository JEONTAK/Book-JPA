package com.example.bookjpa.book.dto;

import com.example.bookjpa.book.entity.Book;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class BookInfoResponse {

    private final Long id;
    private final String title;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    private BookInfoResponse(Long id, String title, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public static BookInfoResponse of(Book book) {
        return new BookInfoResponse(book.getId(), book.getTitle(), book.getCreatedAt(),
                book.getModifiedAt());
    }
}
