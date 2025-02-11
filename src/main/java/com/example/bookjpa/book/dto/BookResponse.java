package com.example.bookjpa.book.dto;

import com.example.bookjpa.author.dto.AuthorInfoResponse;
import com.example.bookjpa.book.entity.Book;
import com.example.bookjpa.user.dto.UserResponse;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;

@Getter
public class BookResponse {

    private final Long id;
    private final String title;
    private final List<AuthorInfoResponse> authors;
    private final UserResponse loanUser;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    private BookResponse(Long id, String title, List<AuthorInfoResponse> authors, UserResponse loanUser,
                         LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.loanUser = loanUser;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public static BookResponse of(Book book, List<AuthorInfoResponse> authors, UserResponse loanUser) {
        return new BookResponse(book.getId(), book.getTitle(), authors, loanUser, book.getCreatedAt(),
                book.getModifiedAt());
    }
}
