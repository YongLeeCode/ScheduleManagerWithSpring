package com.schedulemanager.dto;

import com.schedulemanager.entity.Task;
import lombok.Getter;

import java.sql.Timestamp;

/**
 * @author : yong
 * @packageName : com.schedulemanager.dto
 * @fileName : TaskResponseDto
 * @date : 3/20/25
 * @description :
 */
@Getter
public class TaskResponseDto {
    private Long id;
    private String title;
    private String contents;
    private String userName;

    private Timestamp createdAt;
    private Timestamp updatedAt;

    public TaskResponseDto(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.contents = task.getContents();
        this.userName = task.getUserName();
        this.createdAt = task.getCreatedAt();
        this.updatedAt = task.getUpdatedAt();
    }
}
