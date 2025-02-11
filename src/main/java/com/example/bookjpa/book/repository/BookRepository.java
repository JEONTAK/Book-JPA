package com.example.bookjpa.book.repository;

import com.example.bookjpa.book.entity.Book;
import com.example.bookjpa.util.Exception.CustomExceptionHandler;
import com.example.bookjpa.util.Exception.ErrorCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    default Book findByIdOrElseThrow(Long id){
        return findById(id).orElseThrow(() -> new CustomExceptionHandler(ErrorCode.NOT_FOUND_BOOK));
    }

    Book findByTitle(String title);
}
