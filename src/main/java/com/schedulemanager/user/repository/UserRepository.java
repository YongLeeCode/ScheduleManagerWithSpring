package com.schedulemanager.user.repository;

import com.schedulemanager.user.entity.User;

import java.util.Optional;

/**
 * @author : yong
 * @packageName : com.schedulemanager.user.repository
 * @fileName : UserRepository
 * @date : 3/21/25
 * @description :
 */
public interface UserRepository {
    void save(User user);

    Optional<User> findById(long id);

    void updateById(long id, String password, User user);

    void deleteById(long id, String password);
}
