package com.schedulemanager.task.repository;

import com.schedulemanager.pagination.Pagination;
import com.schedulemanager.task.entity.Task;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * @author : yong
 * @packageName : com.schedulemanager.repository
 * @fileName : JdbcTaskRepository
 * @date : 3/20/25
 * @description : JDBC를 사용하여 MySQL을 연동하여 DB를 사용하고 있습니다.
 */
@Repository
public class JdbcTaskRepository implements TaskRepository{
    JdbcTemplate jdbcTemplate;

    public JdbcTaskRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(Task task) {
        jdbcTemplate.update("INSERT INTO task(title, contents, created_at, updated_at, user_id) " +
                        "VALUES(?, ?, ?, ?, ?);",
                task.getTitle(), task.getContents(), task.getCreatedAt(), task.getUpdatedAt(), task.getUserId());
    }

    @Override
    public List<Task> findAll(Pagination page) {
        return jdbcTemplate.query(
                "SELECT task.id, task.title, task.contents, user.name, task.created_at, task.updated_at " +
                        "FROM task " +
                        "INNER JOIN user ON task.user_id = user.id " +
                        "ORDER BY task.id ASC " +
                        "LIMIT ? OFFSET ?;",
                taskRowMapper(), page.getLimit(), page.getOffset());
    }

    @Override
    public Optional<Task> findById(long id) {
        List<Task> tasks = jdbcTemplate.query(
                "SELECT task.id, task.title, task.contents, user.name, task.created_at, task.updated_at " +
                        "FROM task " +
                        "INNER JOIN user ON task.user_id = user.id" +
                        "WHERE task.id = ?;",
                taskRowMapper(), id);
        return tasks.stream().findAny();
    }

    @Override
    public void updateById(Task task, String password) {
        jdbcTemplate.update("UPDATE task SET title = ?, contents = ?, updated_at = ? " +
                "WHERE id = ?;",
                task.getTitle(), task.getContents(), task.getUpdatedAt(), task.getId());
    }

    @Override
    public void deleteById(long id) {
        jdbcTemplate.update("DELETE FROM task WHERE id = ?;", id);
    }

    @Override
    public long getTotalTaskQuantity() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM task;", Long.class);
    }

    private RowMapper<Task> taskRowMapper() {
        return new RowMapper<Task>() {
            @Override
            public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Task(
                        rs.getLong("task.id"),
                        rs.getString("task.title"),
                        rs.getString("task.contents"),
                        rs.getString("user.name"),
                        rs.getTimestamp("task.created_at"),
                        rs.getTimestamp("task.updated_at")
                );
            }
        };
    }
}
