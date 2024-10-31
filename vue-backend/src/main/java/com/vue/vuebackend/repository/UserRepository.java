package com.vue.vuebackend.repository;

import com.vue.vuebackend.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {

}
