package com.schedulemanager.user.repository;

import com.schedulemanager.user.entity.User;
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
 * @packageName : com.schedulemanager.user.repository
 * @fileName : JdbcUserRepository
 * @date : 3/21/25
 * @description :
 */
@Repository
public class JdbcUserRepository implements UserRepository {
    JdbcTemplate jdbcTemplate;

    public JdbcUserRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(User user) {
        jdbcTemplate.update("INSERT INTO user(name, email, password, created_at, updated_at) VALUES (?, ?, ?, ?, ?)", user.getName(), user.getEmail(), user.getPassword(), user.getCreatedAt(), user.getUpdatedAt());
    }

    @Override
    public Optional<User> findById(long id) {
        List<User> user = jdbcTemplate.query("SELECT * FROM user WHERE id = ?", userRowMapper(), id);
        return user.stream().findAny();
    }

    @Override
    public void updateById(long id, String password, User user) {
        jdbcTemplate.update("UPDATE user SET name = ?, password = ?, updated_at = ? WHERE id = ? AND password = ?", user.getName(), user.getPassword(), user.getUpdatedAt(), id, password);
    }

    @Override
    public void deleteById(long id, String password) {
        jdbcTemplate.update("DELETE FROM user WHERE id = ? AND password = ?", id, password);
    }

    private RowMapper<User> userRowMapper() {
        return new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new User(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("updated_at")
                );
            }
        };
    }
}
