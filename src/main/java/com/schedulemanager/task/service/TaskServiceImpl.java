package com.schedulemanager.task.service;

import com.schedulemanager.task.dto.TaskRequestDto;
import com.schedulemanager.task.dto.TaskResponseDto;
import com.schedulemanager.task.entity.Task;
import com.schedulemanager.task.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author : yong
 * @packageName : com.schedulemanager.service
 * @fileName : TaskServiceImpl
 * @date : 3/20/25
 * @description : Task의 모든 서비스 로직을 담당하고 있습니다.
 */
@Service
public class TaskServiceImpl implements TaskService {
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
        // 데이터 조회
        List<Task> tasks = taskRepository.findAll();
        // Task list -> DTO List 변환
        List<TaskResponseDto> responseDtos = new ArrayList<>();
        tasks.stream().forEach(task -> responseDtos.add(new TaskResponseDto(task)));
        return responseDtos;
    }

    @Override
    public TaskResponseDto findTaskById(long id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.map(TaskResponseDto::new).orElse(null);
    }

    @Override
    public void updateTask(TaskRequestDto dto, String password, long id) {
        Task task = new Task(dto.getTitle(), dto.getContents(), dto.getUserName());
        taskRepository.updateById(task, password, id);
    }

    @Override
    public void deleteTask(String password, long id) {
        taskRepository.deleteById(password, id);
    }
}