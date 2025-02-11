package com.example.bookjpa.util.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    DATA_BAD_REQUEST(400, ""),
    NOT_FOUND_BOOK(404, "책이 존재하지 않습니다."),
    NOT_FOUND_AUTHOR(404, "저자가 존재하지 않습니다."),
    NOT_FOUND_USER(404, "이용자가 존재하지 않습니다."),
    ALREADY_HAVE_AUTHOR(400, "이미 존재하는 저자입니다.");
    private final int status;
    private final String message;
}
