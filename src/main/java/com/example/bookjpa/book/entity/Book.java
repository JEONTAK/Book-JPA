package com.example.bookjpa.book.entity;

import com.example.bookjpa.bookauthor.BookAuthor;
import com.example.bookjpa.user.entity.User;
import com.example.bookjpa.util.TimeStamped;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    @JoinColumn(name = "loan_id")
    private User user;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<BookAuthor> authors = new ArrayList<>();
}
