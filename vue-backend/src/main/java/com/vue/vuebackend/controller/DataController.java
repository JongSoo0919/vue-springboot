package com.vue.vuebackend.controller;

import com.vue.vuebackend.dto.Result;
import com.vue.vuebackend.dto.User;
import com.vue.vuebackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8800")
public class DataController {
    private final UserService userService;

    @GetMapping("/")
    public String home() {
        return "Hello World";
    }

    @GetMapping("/api")
    public String api() {
        return "Api Data 호출 준비";
    }

    @GetMapping("/findAll")

    public Result<List<User>> findAll() {
//        throw new RuntimeException("error~_~_~~_~_");
//        return null;
        return new Result<>(true, userService.findAll(), "전체 조회 성공");
    }

    @PutMapping("/editById")
    public Result<User> editById(@RequestBody User user) {
        return new Result<>(true, userService.edit(user), "사용자 수정 성공");
    }

    @DeleteMapping("/delete/{id}")
    public Result<User> deleteById(@PathVariable Long id) {
        return new Result<>(true, userService.deleteById(id), "사용자 삭제 성공");
    }

    @PostMapping("/save")
    public Result<User> save(@RequestBody User user) {
        return new Result<>(true, userService.save(user), "사용자 저장 성공");
    }
}
