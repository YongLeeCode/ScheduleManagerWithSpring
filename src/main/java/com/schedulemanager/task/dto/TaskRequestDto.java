package com.schedulemanager.task.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author : yong
 * @packageName : com.schedulemanager.dto
 * @fileName : TaskRequestDto
 * @date : 3/20/25
 * @description : 클라이언트 측에서 요청사항으로 제공하는 데이터입니다.
 */

@RequiredArgsConstructor
@Getter
public class TaskRequestDto {
    private final String title;
    private final String contents;
    private final String userName;
    private final String password;
    private final long userId;
}
