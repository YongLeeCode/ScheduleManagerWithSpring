package com.schedulemanager.repository;

import com.schedulemanager.entity.Task;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public void save(Task task) {
        jdbcTemplate.update("INSERT INTO task(title, contents, name, password, createdAt, updatedAt) VALUES(?, ?, ?, ?, ?, ?);", task.getTitle(), task.getContents(), task.getUserName(), task.getPassword(), task.getCreatedAt(), task.getUpdatedAt());
    }

    @Override
    public List<Task> findAll() {
        return jdbcTemplate.query("SELECT * FROM task ORDER BY updated_at DESC", taskRowMapper());
    }

    @Override
    public Optional<Task> findById(long id) {
        List<Task> tasks = jdbcTemplate.query("SELECT * FROM task WHERE id = ?", taskRowMapper(), id);
        return tasks.stream().findAny();
    }

    private RowMapper<Task> taskRowMapper() {
        return new RowMapper<Task>() {
            @Override
            public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Task(
                        rs.getLong("id"),
                        rs.getString("title"),
                        rs.getString("contents"),
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("updated_at")
                );
            }
        };
    }
}
