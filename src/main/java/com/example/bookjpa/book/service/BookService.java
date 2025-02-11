package com.example.bookjpa.book.service;

import com.example.bookjpa.author.dto.AuthorInfoResponse;
import com.example.bookjpa.author.entity.Author;
import com.example.bookjpa.author.service.AuthorService;
import com.example.bookjpa.book.dto.BookInfoResponse;
import com.example.bookjpa.book.dto.BookRequest;
import com.example.bookjpa.book.dto.BookResponse;
import com.example.bookjpa.book.entity.Book;
import com.example.bookjpa.book.repository.BookRepository;
import com.example.bookjpa.util.Exception.CustomExceptionHandler;
import com.example.bookjpa.util.Exception.ErrorCode;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    @Transactional
    public BookInfoResponse save(BookRequest request) {
        Book findBook = bookRepository.findByTitle(request.getTitle());

        if (findBook != null) {
            throw new CustomExceptionHandler(ErrorCode.ALREADY_HAVE_AUTHOR);
        }

        Book book = Book.toEntity(request);
        List<Author> authors = request.getAuthors().stream().map(authorService::findById).toList();
        book.setAuthor(authors);
        bookRepository.save(book);
        return BookInfoResponse.of(book);
    }

    public Page<BookResponse> findAll(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return bookRepository.findAll(pageable).map(book -> BookResponse.of(
                book,
                book.getAuthors().stream().map(author -> AuthorInfoResponse.of(author.getAuthor())).toList()
        ));
    }

    public BookResponse findById(Long id) {
        Book findBook = bookRepository.findByIdOrElseThrow(id);
        return BookResponse.of(findBook,
                findBook.getAuthors().stream().map(author -> AuthorInfoResponse.of(author.getAuthor())).toList()
        );
    }


    @Transactional
    public BookResponse update(Long id, BookRequest request) {
        Book findBook = bookRepository.findByIdOrElseThrow(id);
        List<Author> authors = request.getAuthors().stream().map(authorService::findById).toList();
        findBook.update(request, authors);
        return BookResponse.of(findBook,
                findBook.getAuthors().stream().map(author -> AuthorInfoResponse.of(author.getAuthor())).toList()
        );
    }

    public void delete(Long id) {
        Book findBook = bookRepository.findByIdOrElseThrow(id);
        bookRepository.delete(findBook);
    }
}
