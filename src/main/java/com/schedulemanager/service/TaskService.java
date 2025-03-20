package com.schedulemanager.service;

import com.schedulemanager.dto.TaskRequestDto;
import com.schedulemanager.dto.TaskResponseDto;

import java.util.List;

/**
 * @author : yong
 * @packageName : com.schedulemanager.service
 * @fileName : TaskService
 * @date : 3/20/25
 * @description :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 3/20/25        yong       최초 생성
 */
public interface TaskService {
    void saveTask(TaskRequestDto dto);

    List<TaskResponseDto> findAllTasks();
}
