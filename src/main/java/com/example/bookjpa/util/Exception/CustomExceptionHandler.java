package com.example.bookjpa.util.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomExceptionHandler extends RuntimeException{
    private final ErrorCode errorCode;
}
