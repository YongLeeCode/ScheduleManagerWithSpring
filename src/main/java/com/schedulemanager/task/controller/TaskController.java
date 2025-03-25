package com.schedulemanager.task.controller;

import com.schedulemanager.task.dto.TaskRequestDto;
import com.schedulemanager.task.dto.TaskResponseDto;
import com.schedulemanager.task.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : yong
 * @packageName : com.schedulemanager.controller
 * @fileName : TaskController
 * @date : 3/20/25
 * @description : Task 관련된 모든 컨트롤러입니다.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 3/20/25        yong       최초 생성
 */
@RestController
@RequestMapping("/schedule-manager/task")
public class TaskController {
    TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public void addNewTask(@RequestBody TaskRequestDto dto, @RequestParam String password) {
        taskService.saveTask(dto, password);
    }

    @GetMapping
    public List<TaskResponseDto> findAll(@RequestParam int page) {
        return taskService.findAllTasks(page);
    }

    @GetMapping("/{id}")
    public TaskResponseDto findTaskById(@PathVariable long id) {
        return taskService.findTaskById(id);
    }

    @PatchMapping("/{id}")
    public void updateTask(@RequestBody TaskRequestDto dto, @RequestParam String password, @PathVariable long id) {
        taskService.updateTask(dto, password, id);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@RequestParam String password, @RequestParam long userId, @PathVariable long id) {
        taskService.deleteTask(password, userId, id);
    }

}
