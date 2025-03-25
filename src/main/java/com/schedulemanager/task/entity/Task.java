package com.schedulemanager.task.entity;

import lombok.Getter;

import java.time.LocalDateTime;
import java.sql.Timestamp;

/**
 * @author : yong
 * @packageName : com.schedulemanager.entity
 * @fileName : Task
 * @date : 3/20/25
 * @description : Task Entity
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
    private long userId;

    private Timestamp createdAt;
    private Timestamp updatedAt;

    // save
    public Task(String title, String contents, long userId) {
        this.title = title;
        this.contents = contents;
        this.createdAt = Timestamp.valueOf(LocalDateTime.now());
        this.updatedAt = Timestamp.valueOf(LocalDateTime.now());
        this.userId = userId;
    }

    // update
    public Task(String title, String contents, long id, long userId) {
        this.title = title;
        this.contents = contents;
        this.id = id;
        this.userId = userId;
        this.updatedAt = Timestamp.valueOf(LocalDateTime.now());
    }

    //SELECT task.id, task.title, task.contents, user.name, task.created_at, task.updated_at
    public Task(long id, String title, String contents, String userName, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.userName = userName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
