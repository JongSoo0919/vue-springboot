package com.vue.vuebackend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {
    @GetMapping("/")
    @CrossOrigin(origins = "http://localhost:8800")
    public String home() {
        return "Hello World";
    }

    @GetMapping("/api")
    public String api() {
        return "Api Data 호출 준비";
    }
}
