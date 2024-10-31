package com.vue.vuebackend.service.impl;

import com.vue.vuebackend.dto.User;
import com.vue.vuebackend.entity.Users;
import com.vue.vuebackend.repository.UserRepository;
import com.vue.vuebackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public List<User> findAll() {
        return userRepository.findAll().stream()
                .map(User::of)
                .toList();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .map(User::of)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 번호입니다."));
    }

    @Override
    public User edit(User user) {
        Users u = userRepository.findById(user.no())
                .orElseThrow(() -> new RuntimeException("존재하지 않는 번호입니다."));
        u.updateUser(user);

        return User.of(userRepository.save(u));
    }

    @Override
    public User deleteById(Long id) {
        User user = findById(id);
        userRepository.deleteById(id);

        return user;
    }

    @Override
    public User save(User user) {
        return User.of(userRepository.save(Users.toEntity(user)));
    }

}
