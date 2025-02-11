package com.example.bookjpa.author.service;

import com.example.bookjpa.author.dto.AuthorInfoResponse;
import com.example.bookjpa.author.dto.AuthorRequest;
import com.example.bookjpa.author.dto.AuthorResponse;
import com.example.bookjpa.author.entity.Author;
import com.example.bookjpa.author.repository.AuthorRepository;
import com.example.bookjpa.book.dto.BookInfoResponse;
import com.example.bookjpa.book.entity.Book;
import com.example.bookjpa.book.service.BookServiceForAuthor;
import com.example.bookjpa.bookauthor.BookAuthor;
import com.example.bookjpa.util.Exception.CustomExceptionHandler;
import com.example.bookjpa.util.Exception.ErrorCode;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final BookServiceForAuthor bookServiceForAuthor;

    @Transactional
    public AuthorInfoResponse save(AuthorRequest request) {
        Author findAuthor = authorRepository.findByName(request.getName());

        if (findAuthor != null) {
            throw new CustomExceptionHandler(ErrorCode.ALREADY_HAVE_AUTHOR);
        }

        List<BookAuthor> books = new ArrayList<>();
        Author author = Author.toEntity(request, books);

        authorRepository.save(author);
        return AuthorInfoResponse.of(author);
    }

    public Page<AuthorResponse> findAll(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return authorRepository.findAll(pageable).map(author -> AuthorResponse.of(author,
                author.getBooks().stream().map(book -> BookInfoResponse.of(book.getBook())).toList()));
    }

    public Author findById(Long id) {
        return authorRepository.findByIdOrElseThrow(id);
    }

    public AuthorResponse findBooksById(Long id) {
        Author findAuthor = authorRepository.findByIdOrElseThrow(id);
        return AuthorResponse.of(findAuthor,
                findAuthor.getBooks().stream().map(bookAuthor -> BookInfoResponse.of(bookAuthor.getBook())).toList());
    }

    @Transactional
    public AuthorResponse update(Long id, AuthorRequest request) {
        Author findAuthor = authorRepository.findByIdOrElseThrow(id);
        List<Book> books = request.getBooks().stream().map(bookServiceForAuthor::findById).toList();
        findAuthor.update(request, books);
        return AuthorResponse.of(findAuthor,
                findAuthor.getBooks().stream().map(bookAuthor -> BookInfoResponse.of(bookAuthor.getBook())).toList());
    }

    public void delete(Long id) {
        Author findAuthor = authorRepository.findByIdOrElseThrow(id);
        authorRepository.delete(findAuthor);
    }

}
