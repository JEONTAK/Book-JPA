package com.example.bookjpa.user.dto;

import com.example.bookjpa.book.dto.BookInfoResponse;
import com.example.bookjpa.user.entity.User;
import java.util.List;
import lombok.Getter;

@Getter
public class UserResponse {

    private final Long id;
    private final String name;
    private final List<BookInfoResponse> loanList;

    private UserResponse(Long id, String name, List<BookInfoResponse> loanList) {
        this.id = id;
        this.name = name;
        this.loanList = loanList;
    }

    public static UserResponse of(User user, List<BookInfoResponse> loanList) {
        return new UserResponse(user.getId(), user.getName(), loanList);
    }
}
