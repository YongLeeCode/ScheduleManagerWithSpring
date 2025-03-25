package com.schedulemanager.task.controller;

import com.schedulemanager.task.dto.TaskRequestDto;
import com.schedulemanager.task.dto.TaskResponseDto;
import com.schedulemanager.task.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> addNewTask(@RequestBody @Valid TaskRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body("정상적으로 할 일이 생성되었습니다. Task id : " + taskService.saveTask(dto));
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDto>> findAll(@RequestParam int page) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.findAllTasks(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDto> findTaskById(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.findTaskById(id));
    }

    @PatchMapping
    public ResponseEntity<String> updateTask(@RequestBody @Valid TaskRequestDto dto) {
        taskService.updateTask(dto);
        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 수정 되었습니다.");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteTask(@RequestBody @Valid TaskRequestDto dto) {
        taskService.deleteTask(dto);
        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제 되었습니다.");
    }

}
