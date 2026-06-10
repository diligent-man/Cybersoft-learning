package com.ndt.CRM_project.repo;

import java.sql.*;
import java.util.*;


import tools.jackson.core.JacksonException;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;


import com.ndt.CRM_project.dto.task.UserTaskStatusDetailDTO;
import com.ndt.CRM_project.dto.task.UserTaskStatusStatsDTO;
import com.ndt.CRM_project.entity.UserEntity;
import com.ndt.CRM_project.utils.MysqlConfig;


/**
 * Quản lý tất cả câu query liên quan tới bảng user
 */
public class UserRepo {
    private final ObjectMapper mapper = new ObjectMapper();


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
            System.out.println("UserRepo: Failed to close connection. " + e.getMessage());
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
            System.out.println("UserRepo: Failed to close connection. " + e.getMessage());
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
            System.out.println("UserRepo: Failed to close connection. " + e.getMessage());
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
            System.out.println("UserRepo: Failed to close connection. " + e.getMessage());
        }

        return Optional.ofNullable(objLst.isEmpty() ? null : objLst.getFirst());
    }


    public int save(UserEntity obj) {
        int updatedRow = 0;

        String query = """
            INSERT INTO users(fullname, email, password, phone, role_id) VALUES (?, ?, ?, ?, ?)
            """;

        try (Connection conn = MysqlConfig.getConnection()) {
            try {
                PreparedStatement stmt = conn.prepareStatement(query);

                stmt.setString(1, obj.getFullName());
                stmt.setString(2, obj.getEmail());
                stmt.setString(3, obj.getPassword());
                stmt.setString(4, obj.getPhone());
                stmt.setInt(5, obj.getRoleId());

                updatedRow = stmt.executeUpdate();

            } catch (Exception e) {
                System.out.println("UserRepo: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("UserRepo: Failed to close connection. " + e.getMessage());
        }
        return updatedRow;
    }


    public int update(UserEntity obj) {
        int updatedRow = 0;

        String query = """
            UPDATE users
            SET fullname = ?, email = ?, password = ?, phone = ?, role_id = ?
            WHERE id = ?
            """;

        try (Connection conn = MysqlConfig.getConnection()) {
            try {
                PreparedStatement stmt = conn.prepareStatement(query);

                stmt.setString(1, obj.getFullName());
                stmt.setString(2, obj.getEmail());
                stmt.setString(3, obj.getPassword());
                stmt.setString(4, obj.getPhone());
                stmt.setInt(5, obj.getRoleId());
                stmt.setInt(6, obj.getId());

                updatedRow = stmt.executeUpdate();

            } catch (Exception e) {
                System.out.println("UserRepo: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("UserRepo: Failed to close connection. " + e.getMessage());
        }
        return updatedRow;
    }


    public int delete(int id) {
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
            System.out.println("UserRepo: Failed to close connection. " + e.getMessage());
        }
        return removedRow;
    }


    public Optional<UserTaskStatusStatsDTO> findTaskStatusById(int userId) {
        UserTaskStatusStatsDTO obj = null;

        String query = """
            SELECT u.id,
                   u.fullname,
                   u.email,
                   st.name AS 'status_name',
                   st.color AS 'status_color',
                   SUM(COUNT(t.id)) OVER () AS total_tasks,
                   SUM(COUNT(t.id)) OVER (
                       PARTITION BY st.id
                   ) AS 'total_tasks_by_status',
                   IFNULL(
                        ROUND((COUNT(t.id) / NULLIF(SUM(COUNT(t.id)) OVER(), 0)) * 100, 2),
                        0.
                   ) AS 'task_status_rate',
                   IF(COUNT(t.id) = 0, JSON_ARRAY(),
                        JSON_ARRAYAGG(
                             JSON_OBJECT(
                                      'task_id',            t.id,
                                      'task_name',        t.name,
                                      'start_date', t.start_date,
                                      'end_date',     t.end_date
                              )
                       )
                   ) AS task_details
            FROM users u
                CROSS JOIN status st
                LEFT JOIN tasks t ON t.user_id = u.id AND t.status_id = st.id
            WHERE u.id = ?
            GROUP BY u.id, u.fullname, u.email, st.id, st.name, st.color;
            """;

        try (Connection conn = MysqlConfig.getConnection()) {
            try {
                PreparedStatement stmt = conn.prepareStatement(query);

                stmt.setInt(1, userId);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    if (obj == null) {
                        obj = new UserTaskStatusStatsDTO();

                        obj.setUserId(rs.getInt("id"));
                        obj.setFullName(rs.getString("fullname"));
                        obj.setEmail(rs.getString("email"));
                        obj.setTotalTasks(rs.getInt("total_tasks"));
                    }

                    String statusName = rs.getString("status_name");

                    String statusColor = rs.getString("status_color");
                    obj.getTaskColorMap().put(statusName, statusColor);

                    Integer taskByStatus = rs.getInt("total_tasks_by_status");
                    obj.getTaskStatusMap().put(statusName, taskByStatus);

                    Double taskStatusRate = rs.getDouble("task_status_rate");
                    obj.getTaskStatusRateMap().put(statusName, taskStatusRate);

                    String taskDetailsJson = rs.getString("task_details");
                    List<UserTaskStatusDetailDTO> userTaskDetailsList = mapper.readValue(
                        taskDetailsJson,
                        new TypeReference<>() {
                            // Jackson's solution to Java's type erasure problem by using anonymous subclass
                        }
                    );

                    obj.getTaskStatusDetailMap().put(statusName, userTaskDetailsList);
                }
            } catch (SQLException e) {
                System.out.println("TaskRepo: " + e.getMessage());
            } catch (JacksonException e) {
                System.out.println("TaskRepo - Jackson: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("TaskRepo: Failed to close connection. " + e.getMessage());
        }
        return Optional.ofNullable(obj);
    }
}
