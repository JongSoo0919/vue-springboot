package com.vue.vuebackend.service;

import com.vue.vuebackend.dto.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    User edit(User user);
    User deleteById(Long id);
    User save(User user);

}
