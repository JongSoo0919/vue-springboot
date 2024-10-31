package com.vue.vuebackend.dto;

public record Result<T>(boolean state, T data, String message) {
}
