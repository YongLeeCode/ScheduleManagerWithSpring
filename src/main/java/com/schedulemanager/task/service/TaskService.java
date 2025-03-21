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
    void saveTask(TaskRequestDto dto);

    List<TaskResponseDto> findAllTasks();

    TaskResponseDto findTaskById(long id);

    void updateTask(TaskRequestDto dto, String password, long id);

    void deleteTask(String password, long id);
}
