package com.schedulemanager.user.repository;

import com.schedulemanager.user.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    public long save(User user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                con -> {
                    PreparedStatement ps = con.prepareStatement(
                            "INSERT INTO user(name, email, password, created_at, updated_at) VALUES (?, ?, ?, ?, ?)",
                            Statement.RETURN_GENERATED_KEYS
                    );
                    ps.setString(1, user.getName());
                    ps.setString(2, user.getEmail());
                    ps.setString(3, user.getPassword());
                    ps.setTimestamp(4, user.getCreatedAt());
                    ps.setTimestamp(5, user.getUpdatedAt());
                    return ps;
                    }, keyHolder
        );

        return keyHolder.getKey().longValue();
    }

    @Override
    public Optional<User> findById(long id) {
        List<User> user = jdbcTemplate.query("SELECT * FROM user WHERE id = ?", userRowMapper(), id);
        return user.stream().findAny();
    }

    @Override
    public long updateById(User user) {
        jdbcTemplate.update("UPDATE user SET name = ?, password = ?, updated_at = ? WHERE id = ?;",
                user.getName(), user.getPassword(), user.getUpdatedAt(), user.getId());
        return user.getId();
    }

    @Override
    public long deleteById(long id) {
        jdbcTemplate.update("DELETE FROM user WHERE id = ?;", id);
        return id;
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
