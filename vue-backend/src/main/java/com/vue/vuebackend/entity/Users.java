package com.vue.vuebackend.entity;

import ch.qos.logback.core.util.StringUtil;
import com.vue.vuebackend.dto.User;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    private String name;

    private String email;

    private String pwd;

    private Boolean gender;

    private Boolean del;

    @CreatedDate
    private LocalDateTime regDate;

    @Builder
    public Users(String name, String email, String pwd, Boolean gender) {
        this.name = name;
        this.email = email;
        this.pwd = pwd;
        this.gender = gender;
        this.del = false;
        this.regDate  = LocalDateTime.now();
    }

    public static Users toEntity(User user) {
        return Users.builder()
                .name(user.name())
                .email(user.email())
                .pwd(user.pwd())
                .gender(user.gender())
                .build();
    }

    public void updateUser(User user) {
        this.name = StringUtils.isEmpty(user.name()) ? this.name : user.name();
        this.email = StringUtils.isEmpty(user.email()) ? this.email : user.email();
        this.pwd = StringUtils.isEmpty(user.pwd()) ? this.pwd : user.pwd();
    }
}
