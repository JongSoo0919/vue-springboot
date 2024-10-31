package com.vue.vuebackend.dto;

import com.vue.vuebackend.entity.Users;

public record User(Long no, String name, String email, String pwd, Boolean gender) {
    public User(Long no, String name, String email, String pwd, Boolean gender) {
        this.no = no;
        this.name = name;
        this.email = email;
        this.pwd = pwd;
        this.gender = gender;
    }

    public static User of(Users users) {
        return new User(users.getNo(), users.getName(), users.getEmail(), users.getPwd(), users.getGender());
    }
}
