package com.schedulemanager.task.service;

import com.schedulemanager.task.dto.TaskRequestDto;
import com.schedulemanager.task.dto.TaskResponseDto;

import java.util.List;

/**
 * @author : yong
 * @packageName : com.schedulemanager.service
 * @fileName : TaskService
 * @date : 3/20/25
 * @description : Task Service
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 3/20/25        yong       최초 생성
 */
public interface TaskService {
    long saveTask(TaskRequestDto dto);

    List<TaskResponseDto> findAllTasks(int page);

    TaskResponseDto findTaskById(long id);

    void updateTask(TaskRequestDto dto);

    void deleteTask(TaskRequestDto dto);
}
