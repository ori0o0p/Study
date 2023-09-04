package com.example.shoppingmall.domain.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@RequiredArgsConstructor
@Document
public class User {

    @Id
    private String id;

    @NotBlank
    private String email;

    @NotBlank
    private String name;

    @NotBlank
    @JsonIgnore
    private String password;

    @NotBlank
    private Role role;

    @Builder
    public User(String name, String email, String password, Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
