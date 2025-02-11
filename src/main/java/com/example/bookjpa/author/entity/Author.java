package com.example.bookjpa.author.entity;

import com.example.bookjpa.author.dto.AuthorRequest;
import com.example.bookjpa.book.entity.Book;
import com.example.bookjpa.bookauthor.BookAuthor;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "author")
@Getter
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookAuthor> books = new ArrayList<>();

    private Author(String name, List<BookAuthor> books) {
        this.name = name;
        this.books = books;
    }

    public static Author toEntity(AuthorRequest request, List<BookAuthor> books) {
        return new Author(request.getName(), books);
    }

    public void update(AuthorRequest request, List<Book> books) {
        this.name = request.getName();
        this.books.clear();
        this.books.addAll(books.stream().map(book -> BookAuthor.of(book, this)).toList());
    }
}
