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
    void save(UserRequestDto dto);

    UserResponseDto findUserById(long id);

    void updateUser(long id, String password, UserRequestDto dto);

    void deleteUser(long id, String password);
}
