package com.example.bookjpa.book.entity;

import com.example.bookjpa.author.entity.Author;
import com.example.bookjpa.book.dto.BookRequest;
import com.example.bookjpa.bookauthor.BookAuthor;
import com.example.bookjpa.util.TimeStamped;
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
@Table(name = "book")
@Getter
@NoArgsConstructor
public class Book extends TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookAuthor> authors = new ArrayList<>();

    private Book(String title) {
        this.title = title;
    }

    public static Book toEntity(BookRequest request) {
        return new Book(request.getTitle());
    }

    public void setAuthor(List<Author> authors) {
        this.authors.addAll(authors.stream().map(author -> BookAuthor.of(this, author)).toList());
    }

    public void update(BookRequest request, List<Author> authors) {
        this.title = request.getTitle();
        this.authors.clear();
        this.authors.addAll(authors.stream().map(author -> BookAuthor.of(this, author)).toList());
    }
}
