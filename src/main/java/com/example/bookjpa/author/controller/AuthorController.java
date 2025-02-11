package com.example.bookjpa.author.controller;

import com.example.bookjpa.author.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;
}
