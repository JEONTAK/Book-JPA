package com.example.bookjpa.author.repository;

import com.example.bookjpa.author.entity.Author;
import com.example.bookjpa.util.Exception.CustomExceptionHandler;
import com.example.bookjpa.util.Exception.ErrorCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findByName(String name);

    default Author findByIdOrElseThrow(Long id){
        return findById(id).orElseThrow(() -> new CustomExceptionHandler(ErrorCode.NOT_FOUND_AUTHOR));
    }
}
