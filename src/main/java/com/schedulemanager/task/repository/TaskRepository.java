package com.schedulemanager.task.repository;

import com.schedulemanager.pagination.Pagination;
import com.schedulemanager.task.entity.Task;

import java.util.List;
import java.util.Optional;

/**
 * @author : yong
 * @packageName : com.schedulemanager.repository
 * @fileName : TaskRepository
 * @date : 3/20/25
 * @description : Task Repository
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 3/20/25        yong       최초 생성
 */
public interface TaskRepository {
    void save(Task task);

    List<Task> findAll(Pagination page);

    Optional<Task> findById(long id);

    void updateById(Task task, String password, long id);

    void deleteById(String password, long id);

    long getTotalTaskQuantity();
}
