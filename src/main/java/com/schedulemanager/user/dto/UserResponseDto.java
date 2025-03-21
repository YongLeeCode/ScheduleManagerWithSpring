package com.schedulemanager.user.dto;

import com.schedulemanager.user.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

/**
 * @author : yong
 * @packageName : com.schedulemanager.user.dto
 * @fileName : UserResponseDto
 * @date : 3/21/25
 * @description :
 */
@Getter
public class UserResponseDto {
    private final long id;
    private final String name;
    private final String email;
    private final String password;
    private final Timestamp createdAt;
    private final Timestamp updatedAt;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();
    }
}
