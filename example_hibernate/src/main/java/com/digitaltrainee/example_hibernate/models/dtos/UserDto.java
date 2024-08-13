package com.digitaltrainee.example_hibernate.models.dtos;

import com.digitaltrainee.example_hibernate.models.User;

public class UserDto {
    private String title;
    private User user;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
