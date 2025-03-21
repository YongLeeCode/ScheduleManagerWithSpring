package com.schedulemanager.task.dto;

import com.schedulemanager.task.entity.Task;
import lombok.Getter;

import java.sql.Timestamp;

/**
 * @author : yong
 * @packageName : com.schedulemanager.dto
 * @fileName : TaskResponseDto
 * @date : 3/20/25
 * @description : 클라이언트에서 응답으로 받을 데이터입니다.
 */
@Getter
public class TaskResponseDto {
    private final Long id;
    private final String title;
    private final String contents;
    private final String userName;

    private final Timestamp createdAt;
    private final Timestamp updatedAt;

    public TaskResponseDto(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.contents = task.getContents();
        this.userName = task.getUserName();
        this.createdAt = task.getCreatedAt();
        this.updatedAt = task.getUpdatedAt();
    }
}
