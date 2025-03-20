package com.schedulemanager.service;

import com.schedulemanager.dto.TaskRequestDto;
import com.schedulemanager.dto.TaskResponseDto;
import com.schedulemanager.entity.Task;
import com.schedulemanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : yong
 * @packageName : com.schedulemanager.service
 * @fileName : TaskServiceImpl
 * @date : 3/20/25
 * @description :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 3/20/25        yong       최초 생성
 */
@Service
public class TaskServiceImpl implements TaskService{
    TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void saveTask(TaskRequestDto dto) {
        Task task = new Task(dto.getTitle(), dto.getContents(), dto.getUserName(), dto.getPassword());
        taskRepository.save(task);
    }

    @Override
    public List<TaskResponseDto> findAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        List<TaskResponseDto> responseDtos = new ArrayList<>();
        for(Task task : tasks) {
            responseDtos.add(new TaskResponseDto(task));
        }
        return responseDtos;
    }


}
