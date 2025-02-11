package com.example.bookjpa.book.controller;

import com.example.bookjpa.book.dto.BookInfoResponse;
import com.example.bookjpa.book.dto.BookRequest;
import com.example.bookjpa.book.dto.BookResponse;
import com.example.bookjpa.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/books")
    public ResponseEntity<BookInfoResponse> save(@RequestBody BookRequest request) {
        BookInfoResponse response = bookService.save(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/books")
    public ResponseEntity<Page<BookResponse>> findAll(@RequestParam(defaultValue = "0") Integer pageNumber,
                                                      @RequestParam(defaultValue = "10") Integer pageSize) {
        Page<BookResponse> authorResponsePage = bookService.findAll(pageNumber, pageSize);
        return ResponseEntity.ok(authorResponsePage);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<BookResponse> findById(@PathVariable Long id) {
        BookResponse response = bookService.findById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<BookResponse> update(@PathVariable Long id,
                                                 @RequestBody BookRequest request) {
        BookResponse response = bookService.update(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
