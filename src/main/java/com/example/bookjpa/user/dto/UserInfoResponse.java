package com.example.bookjpa.user.dto;

import com.example.bookjpa.user.entity.User;
import lombok.Getter;

@Getter
public class UserInfoResponse {

    private final Long id;
    private final String name;

    private UserInfoResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static UserInfoResponse of(User user) {
        return new UserInfoResponse(user.getId(), user.getName());
    }
}
