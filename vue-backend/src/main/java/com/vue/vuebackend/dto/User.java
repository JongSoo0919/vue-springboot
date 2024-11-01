package com.vue.vuebackend.dto;

import com.vue.vuebackend.entity.Users;

import java.time.LocalDateTime;

public record User(Long no, String name, String email, String pwd, Boolean gender, LocalDateTime regDate) {
    public User(Long no, String name, String email, String pwd, Boolean gender, LocalDateTime regDate) {
        this.no = no;
        this.name = name;
        this.email = email;
        this.pwd = pwd;
        this.gender = gender;
        this.regDate = regDate;
    }

    public static User of(Users users) {
        return new User(users.getNo(), users.getName(), users.getEmail(), users.getPwd(), users.getGender(), users.getRegDate());
    }
}
