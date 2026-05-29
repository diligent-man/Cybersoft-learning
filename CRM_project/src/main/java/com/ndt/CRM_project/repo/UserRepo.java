package com.ndt.CRM_project.repo;

import java.sql.*;
import java.util.*;

import com.ndt.CRM_project.entity.UserEntity;
import com.ndt.CRM_project.utils.MysqlConfig;


/**
 * Quản lý tất cả câu query liên quan tới bảng user
 */
public class UserRepo {
    public List<UserEntity> findAll() {
        List<UserEntity> users = new ArrayList<>();
        String query = """
                SELECT u.id, u.first_name, u.last_name, u.email, r.name AS role_name
                FROM users u
                JOIN roles r ON u.role_id = r.id
            """;
        try {
            Connection conn = MysqlConfig.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                UserEntity user = new UserEntity();
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setRoleName(rs.getString("role_name"));

                users.add(user);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return users;
    }


    public Optional<UserEntity> findByEmailAndPassword(String email, String password) {
        List<UserEntity> users = new ArrayList<>();

        try {
            // evade SQL Injection with "?"
            String sql = """
                SELECT u.id, u.fullname, r.name AS role_name
                FROM users u
                JOIN roles r
                    ON r.id = u.role_id
                WHERE u.email=? AND u.password=?
                """;
            Connection conn = MysqlConfig.getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            // parameterIndex starts from 1 from the left
            statement.setString(1, email);
            statement.setString(2, password);

            // convert result set objects to user class
            users = new ArrayList<>();

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                UserEntity user = new UserEntity(
                );

                user.setId(rs.getInt("id"));
                user.setFullname(rs.getString("fullname"));
                user.setRoleName(rs.getString("role_name"));

                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return Optional.ofNullable(users.getFirst());
    }
}
