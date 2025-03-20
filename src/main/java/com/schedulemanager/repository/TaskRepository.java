package com.schedulemanager.repository;

import com.schedulemanager.entity.Task;

import java.util.List;

/**
 * @author : yong
 * @packageName : com.schedulemanager.repository
 * @fileName : TaskRepository
 * @date : 3/20/25
 * @description :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 3/20/25        yong       최초 생성
 */
public interface TaskRepository {
    void save(Task task);
    List<Task> findAll();
}
