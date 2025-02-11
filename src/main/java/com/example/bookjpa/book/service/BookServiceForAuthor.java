package com.example.bookjpa.book.service;

import com.example.bookjpa.book.entity.Book;
import com.example.bookjpa.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceForAuthor {

    private final BookRepository bookRepository;

    public Book findById(Long id) {
        return bookRepository.findByIdOrElseThrow(id);
    }
}
