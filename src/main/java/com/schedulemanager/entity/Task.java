package com.schedulemanager.entity;

import lombok.Getter;

import java.time.LocalDateTime;
import java.sql.Timestamp;

/**
 * @author : yong
 * @packageName : com.schedulemanager.entity
 * @fileName : Task
 * @date : 3/20/25
 * @description :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 3/20/25        yong       최초 생성
 */

@Getter
public class Task {
    private Long id;
    private String title;
    private String contents;
    private String userName;
    private String password;

    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Task(String title, String contents, String userName, String password) {
        this.title = title;
        this.contents = contents;
        this.userName = userName;
        this.password = password;
        this.createdAt = Timestamp.valueOf(LocalDateTime.now());
        this.updatedAt = Timestamp.valueOf(LocalDateTime.now());
    }

    public Task(long id, String title, String contents, String userName, String password, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.userName = userName;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
