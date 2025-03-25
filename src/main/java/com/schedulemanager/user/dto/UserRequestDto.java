package com.schedulemanager.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author : yong
 * @packageName : com.schedulemanager.user.dto
 * @fileName : UserRequestDto
 * @date : 3/21/25
 * @description :
 */
@Getter
@RequiredArgsConstructor
public class UserRequestDto {
    private final String name;
    @Email
    private final String email;
    private final String password;
}
