package com.schedulemanager.task.service;

import com.schedulemanager.pagination.Pagination;
import com.schedulemanager.task.dto.TaskRequestDto;
import com.schedulemanager.task.dto.TaskResponseDto;
import com.schedulemanager.task.entity.Task;
import com.schedulemanager.task.repository.TaskRepository;
import com.schedulemanager.user.entity.User;
import com.schedulemanager.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.sql.Timestamp;
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
    private TaskRepository taskRepository;
    private UserRepository userRepository;
    private int QUANTITY_PER_PAGE =  5;

    public TaskServiceImpl(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void saveTask(TaskRequestDto dto, String password) {
        User user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new NullPointerException("회원이 아니신거같은데요..."));
        if(user.getPassword().equals(password)) {
            Task task = new Task(dto.getTitle(), dto.getContents(), dto.getUserId());
            taskRepository.save(task);
        } else {
            throw new RuntimeException("비밀번호가 틀렸어요");
        }
    }

    @Override
    public List<TaskResponseDto> findAllTasks(int page) {
        long totalQueryCount = taskRepository.getTotalTaskQuantity();

        Pagination pagination;
        if(totalQueryCount > ((long) QUANTITY_PER_PAGE * page - QUANTITY_PER_PAGE)
                && page >= 1) {
            pagination = new Pagination( QUANTITY_PER_PAGE, page);
        } else {
            return new ArrayList<>();
        }
        // 데이터 조회
        List<Task> tasks = taskRepository.findAll(pagination);
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
        User user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new NullPointerException("회원 아이디를 확인해주세요"));
        if(user.getPassword().equals(password)) {
            Task task = new Task(dto.getTitle(), dto.getContents(), id, dto.getUserId());
            taskRepository.updateById(task, password);
        } else {
            throw new RuntimeException("비밀번호가 틀렸어요");
        }
    }

    @Override
    public void deleteTask(String password, long userId, long id) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NullPointerException("회원 아이디를 확인해주세요"));
        if(user.getPassword().equals(password)) {
            taskRepository.deleteById(id);
        } else {
            throw new RuntimeException("비밀번호가 틀렸어요");
        }

    }
}