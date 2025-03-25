package com.schedulemanager.user.entity;

import lombok.Getter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author : yong
 * @packageName : com.schedulemanager.user.entity
 * @fileName : User
 * @date : 3/21/25
 * @description :
 */
@Getter
public class User {
    private long id;
    private String name;
    private String email;
    private String password;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public User(long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.updatedAt = Timestamp.valueOf(LocalDateTime.now());
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.createdAt = Timestamp.valueOf(LocalDateTime.now());
        this.updatedAt = Timestamp.valueOf(LocalDateTime.now());
    }

    public User(long id, String name, String email, String password, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
