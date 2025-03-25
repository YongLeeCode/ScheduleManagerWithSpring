package com.schedulemanager.task.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
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
    private final long id;

    @Size(max=20)
    private final String title;

    @Size(max=200)
    private final String contents;

    @NotNull
    private final String password;

    @Positive
    private final long userId;


}
