package com.schedulemanager.controller;

import com.schedulemanager.dto.TaskRequestDto;
import com.schedulemanager.dto.TaskResponseDto;
import com.schedulemanager.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : yong
 * @packageName : com.schedulemanager.controller
 * @fileName : TaskController
 * @date : 3/20/25
 * @description :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 3/20/25        yong       최초 생성
 */
@RestController
@RequestMapping("/schedule-manager")
public class TaskController {
    TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public void addNewTask(@RequestBody TaskRequestDto dto) {
        taskService.saveTask(dto);
    }

    @GetMapping
    public List<TaskResponseDto> findAll() {
        return taskService.findAllTasks();
    }
}
