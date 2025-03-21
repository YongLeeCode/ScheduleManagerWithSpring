package com.schedulemanager.user.dto;

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
    private final String email;
    private final String password;
}
