package com.ndt.CRM_project.repo;

import java.sql.*;
import java.util.*;

import com.ndt.CRM_project.entity.User;
import com.ndt.CRM_project.utils.MysqlConfig;


/**
 * Quản lý tất cả câu query liên quan tới bảng user
 */
public class UserRepo {
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
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
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String role = rs.getString("role_name");

                User user = new User(id, firstName, lastName, email, role);
                users.add(user);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return users;
    }


    public List<User> findUserByEmailAndPassword(String email, String password) {
        List<User> users = new ArrayList<>();

        try {
            // evade SQL Injection with "?"
            String sql = "SELECT id, email, password FROM users WHERE email=? AND password=?";
            Connection conn = MysqlConfig.getConnection();

            PreparedStatement statement = conn.prepareStatement(sql);

            // parameterIndex starts from 1 from the left
            statement.setString(1, email);
            statement.setString(2, password);

            // convert result set objects to user class
            users = new ArrayList<>();

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User user = new User(
                    rs.getInt("id"),
                    rs.getString("email"),
                    rs.getString("password")
                );

                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return users;
    }
}
