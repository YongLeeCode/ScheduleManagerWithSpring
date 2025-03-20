package com.schedulemanager.dto;

import lombok.Getter;

/**
 * @author : yong
 * @packageName : com.schedulemanager.dto
 * @fileName : TaskRequestDto
 * @date : 3/20/25
 * @description :

 */

@Getter
public class TaskRequestDto {
    private String title;
    private String contents;
    private String userName;
    private String password;

    public TaskRequestDto(String title, String contents, String userName, String password) {
        this.title = title;
        this.contents = contents;
        this.userName = userName;
        this.password = password;
    }
}
