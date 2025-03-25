package com.schedulemanager.user.service;

import com.schedulemanager.task.dto.TaskResponseDto;
import com.schedulemanager.task.entity.Task;
import com.schedulemanager.user.dto.UserRequestDto;
import com.schedulemanager.user.dto.UserResponseDto;
import com.schedulemanager.user.entity.User;
import com.schedulemanager.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

/**
 * @author : yong
 * @packageName : com.schedulemanager.user.service
 * @fileName : UserServiceImpl
 * @date : 3/21/25
 * @description :
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public void save(UserRequestDto dto) {
        User user = new User(dto.getName(), dto.getEmail(), dto.getPassword());
        userRepository.save(user);
    }

    @Override
    public UserResponseDto findUserById(long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NullPointerException("회원 정보를 찾을 수 없습니다."));
        return new UserResponseDto(user);
    }

    @Override
    public void updateUser(long id, String password, UserRequestDto dto) {
        User user = userRepository.findById(id).orElseThrow(() -> new NullPointerException("회원 정보를 찾을 수 없습니다."));
        if (user.getPassword().equals(password)) {
            User userEntity = new User(id, dto.getName(), dto.getPassword());
            userRepository.updateById(userEntity);
        } else {
            throw new RuntimeException("비밀번호가 일치하지 않습니다!");
        }
    }

    @Override
    public void deleteUser(long id, String password) {
        User user = userRepository.findById(id).orElseThrow(() -> new NullPointerException("회원 정보를 찾을 수 없습니다."));
        if (user.getPassword().equals(password)) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("비밀번호가 일치하지 않습니다!");
        }
    }
}
