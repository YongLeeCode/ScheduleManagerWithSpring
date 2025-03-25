package com.schedulemanager.user.service;

import com.schedulemanager.user.dto.UserRequestDto;
import com.schedulemanager.user.dto.UserResponseDto;

/**
 * @author : yong
 * @packageName : com.schedulemanager.user.service
 * @fileName : UserService
 * @date : 3/21/25
 * @description :
 */
public interface UserService {
    long save(UserRequestDto dto);

    UserResponseDto findUserById(long id);

    long updateUser(long id, String password, UserRequestDto dto);

    long deleteUser(long id, String password);
}
