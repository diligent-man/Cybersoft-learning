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

        try (Connection conn = MysqlConfig.getConnection()) {
            try {
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
            } catch (SQLException e) {
                System.out.println("UserRepo: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("RoleRepo: Failed to close connection. " + e.getMessage());
        }
        return users;
    }


    // TODO: make email unique
    public Optional<UserEntity> findByEmail(String email) {
        // evade SQL Injection with "?"
        String query = """
            SELECT u.id, u.fullname, u.password, r.name AS role_name
            FROM users u
            JOIN roles r
                ON r.id = u.role_id
            WHERE u.email=?
            """;

        List<UserEntity> users = new ArrayList<>();
        try (Connection conn = MysqlConfig.getConnection()) {
            try {
                PreparedStatement statement = conn.prepareStatement(query);

                // parameterIndex starts from 1 from the left
                statement.setString(1, email);

                // convert result set objects to user class
                users = new ArrayList<>();

                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    UserEntity user = new UserEntity();

                    user.setId(rs.getInt("id"));
                    user.setPassword(rs.getString("password"));
                    user.setFullname(rs.getString("fullname"));
                    user.setRoleName(rs.getString("role_name"));

                    users.add(user);
                }
            } catch (SQLException e) {
                System.out.println("UserRepo: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("RoleRepo: Failed to close connection. " + e.getMessage());
        }

        return Optional.ofNullable(users.isEmpty() ? null : users.getFirst());
    }


    public int save(UserEntity user) {
        int updatedRow = 0;

        String query = """
            INSERT INTO users(fullname, email, password, phone, role_id) VALUES (?, ?, ?, ?, ?)
            """;

        try (Connection conn = MysqlConfig.getConnection()) {
            try {
                PreparedStatement stmt = conn.prepareStatement(query);

                stmt.setString(1, user.getFullname());
                stmt.setString(2, user.getEmail());
                stmt.setString(3, user.getPassword());
                stmt.setString(4, user.getPhone());
                stmt.setInt(5, user.getRoleId());

                updatedRow = stmt.executeUpdate();

            } catch (Exception e) {
                System.out.println("UserRepo: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("RoleRepo: Failed to close connection. " + e.getMessage());
        }
        return updatedRow;
    }
}
