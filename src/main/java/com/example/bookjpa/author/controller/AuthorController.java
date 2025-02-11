package com.example.bookjpa.author.controller;

import com.example.bookjpa.author.dto.AuthorInfoResponse;
import com.example.bookjpa.author.dto.AuthorRequest;
import com.example.bookjpa.author.dto.AuthorResponse;
import com.example.bookjpa.author.service.AuthorService;
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
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping("/authors")
    public ResponseEntity<AuthorInfoResponse> save(@RequestBody AuthorRequest request) {
        AuthorInfoResponse response = authorService.save(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/authors")
    public ResponseEntity<Page<AuthorResponse>> findAll(@RequestParam(defaultValue = "0") Integer pageNumber,
                                                        @RequestParam(defaultValue = "10") Integer pageSize) {
        Page<AuthorResponse> authorResponsePage = authorService.findAll(pageNumber, pageSize);
        return ResponseEntity.ok(authorResponsePage);
    }

    @GetMapping("/authors/{id}")
    public ResponseEntity<AuthorResponse> findBooksById(@PathVariable Long id) {
        AuthorResponse response = authorService.findBooksById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/authors/{id}")
    public ResponseEntity<AuthorResponse> update(@PathVariable Long id,
                                                 @RequestBody AuthorRequest request) {
        AuthorResponse response = authorService.update(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/authors/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        authorService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
