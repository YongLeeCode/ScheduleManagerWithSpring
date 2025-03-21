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
        Optional<User> user = userRepository.findById(id);
        return user.map(UserResponseDto::new).orElse(null);
    }

    @Override
    public void updateUser(long id, String password, UserRequestDto dto) {
        User user = new User(dto.getName(), dto.getPassword());
        userRepository.updateById(id, password, user);
    }

    @Override
    public void deleteUser(long id, String password) {
        userRepository.deleteById(id, password);
    }
}
