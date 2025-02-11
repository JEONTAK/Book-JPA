package com.example.bookjpa.user.dto;

import lombok.Getter;

@Getter
public class UserRequest {

    private final String name;

    private UserRequest(String name) {
        this.name = name;
    }
}
