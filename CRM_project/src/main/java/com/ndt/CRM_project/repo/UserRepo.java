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
                SELECT u.id, u.fullname, u.first_name, u.last_name, u.email, r.name AS role_name
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
                    user.setFullName(rs.getString("fullname"));
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


    public List<UserEntity> findByOffset(int page, int pageSize) {
        // page 1 → offset 0, page 2 → offset 10
        int offset = (page - 1) * pageSize;

        String query = """
                SELECT u.id, u.fullname,
                       u.first_name, u.last_name,
                       u.email,
                       r.name AS role_name
                FROM users u
                    JOIN roles r ON u.role_id = r.id
                LIMIT ?
                OFFSET ?
            """;

        List<UserEntity> users = new ArrayList<>();
        try (Connection conn = MysqlConfig.getConnection()) {
            try {
                PreparedStatement stmt = conn.prepareStatement(query);

                stmt.setInt(1, pageSize);
                stmt.setInt(2, offset);

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    UserEntity u = new UserEntity();

                    u.setId(rs.getInt("id"));
                    u.setFullName(rs.getString("fullname"));
                    u.setFirstName(rs.getString("first_name"));
                    u.setLastName(rs.getString("last_name"));
                    u.setEmail(rs.getString("email"));
                    u.setRoleName(rs.getString("role_name"));

                    users.add(u);
                }
            } catch (SQLException e) {
                System.out.println("UserRepo: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("RoleRepo: Failed to close connection. " + e.getMessage());
        }
        return users;
    }


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
                    user.setFullName(rs.getString("fullname"));
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


    public Optional<UserEntity> findById(int id) {
        // evade SQL Injection with "?"
        String query = """
            SELECT u.id, u.fullname, u.email, u.password, u.phone, r.name AS role_name
            FROM users u
            JOIN roles r
                ON r.id = u.role_id
            WHERE u.id=?
            """;

        List<UserEntity> objLst = new ArrayList<>();
        try (Connection conn = MysqlConfig.getConnection()) {
            try {
                PreparedStatement statement = conn.prepareStatement(query);

                // parameterIndex starts from 1 from the left
                statement.setInt(1, id);

                // convert result set objects to user class
                objLst = new ArrayList<>();

                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    UserEntity obj = new UserEntity();

                    obj.setId(rs.getInt("id"));
                    obj.setFullName(rs.getString("fullname"));
                    obj.setEmail(rs.getString("email"));
                    obj.setPassword(rs.getString("password"));
                    obj.setPhone(rs.getString("phone"));
                    obj.setRoleName(rs.getString("role_name"));

                    objLst.add(obj);
                }
            } catch (SQLException e) {
                System.out.println("UserRepo: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("RoleRepo: Failed to close connection. " + e.getMessage());
        }

        return Optional.ofNullable(objLst.isEmpty() ? null : objLst.getFirst());
    }


    public int update(UserEntity user) {
        int updatedRow = 0;

        String query = """
            UPDATE users
            SET fullname = ?, email = ?, password = ?, phone = ?, role_id = ?
            WHERE id = ?
            """;

        try (Connection conn = MysqlConfig.getConnection()) {
            try {
                PreparedStatement stmt = conn.prepareStatement(query);

                stmt.setString(1, user.getFullName());
                stmt.setString(2, user.getEmail());
                stmt.setString(3, user.getPassword());
                stmt.setString(4, user.getPhone());
                stmt.setInt(5, user.getRoleId());
                stmt.setInt(6, user.getId());

                updatedRow = stmt.executeUpdate();

            } catch (Exception e) {
                System.out.println("UserRepo: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("RoleRepo: Failed to close connection. " + e.getMessage());
        }
        return updatedRow;
    }


    public int save(UserEntity user) {
        int updatedRow = 0;

        String query = """
            INSERT INTO users(fullname, email, password, phone, role_id) VALUES (?, ?, ?, ?, ?)
            """;

        try (Connection conn = MysqlConfig.getConnection()) {
            try {
                PreparedStatement stmt = conn.prepareStatement(query);

                stmt.setString(1, user.getFullName());
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


    public int deleteById(Integer id) {
        int removedRow = 0;

        String query = """
            DELETE
            FROM users
            WHERE id = ?
            """;

        try (Connection conn = MysqlConfig.getConnection()) {
            try {
                PreparedStatement stmt = conn.prepareStatement(query);

                stmt.setInt(1, id);
                removedRow = stmt.executeUpdate();

            } catch (Exception e) {
                System.out.println("UserRepo: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("RoleRepo: Failed to close connection. " + e.getMessage());
        }
        return removedRow;
    }
}
