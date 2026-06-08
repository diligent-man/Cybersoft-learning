package com.ndt.CRM_project.repo;

import java.sql.*;
import java.sql.PreparedStatement;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;


import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;


import com.ndt.CRM_project.utils.MysqlConfig;

import com.ndt.CRM_project.entity.TaskEntity;

import com.ndt.CRM_project.dto.task.TaskStatusCountDTO;
import com.ndt.CRM_project.dto.task.UserTaskStatusStatsDTO;
import com.ndt.CRM_project.dto.task.UserTaskStatusDetailDTO;


/**
 * Quản lý tất cả câu query liên quan tới bảng task
 */
public class TaskRepo {
    private final ObjectMapper mapper = new ObjectMapper();


    public List<TaskEntity> findAll() {
        List<TaskEntity> objLst = new ArrayList<>();

        String query = """
                SELECT t.id, t.name, t.start_date, t.end_date,
                       prj.name AS 'project_name',
                       st.name AS 'status_name', st.color AS 'status_color',
                       u.fullname AS 'user_name'
                FROM tasks t
                    JOIN projects prj ON t.project_id = prj.id
                    JOIN status st ON t.status_id = st.id
                    JOIN users u ON t.user_id = u.id
            """;
        try (Connection conn = MysqlConfig.getConnection()) {
            try {
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    TaskEntity obj = new TaskEntity();

                    obj.setId(rs.getInt("id"));
                    obj.setName(rs.getString("name"));
                    obj.setStartDate(rs.getString("start_date"));
                    obj.setEndDate(rs.getString("end_date"));
                    obj.setProjectName(rs.getString("project_name"));
                    obj.setStatusName(rs.getString("status_name"));
                    obj.setStatusColor(rs.getString("status_color"));
                    obj.setUserFullName(rs.getString("user_name"));

                    objLst.add(obj);
                }
            } catch (SQLException e) {
                System.out.println("TaskRepo: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("TaskRepo: Failed to close connection. " + e.getMessage());
        }
        return objLst;
    }


    public Optional<TaskEntity> findById(int id) {
        // evade SQL Injection with "?"
        String query = """
                SELECT t.id, t.name, t.start_date, t.end_date,
                       prj.name AS 'project_name',
                       st.name AS 'status_name', st.color AS 'status_color',
                       u.fullname AS 'user_name'
                FROM tasks t
                    JOIN projects prj ON t.project_id = prj.id
                    JOIN status st ON t.status_id = st.id
                    JOIN users u ON t.user_id = u.id
                WHERE t.id=?
            """;

        List<TaskEntity> objLst = new ArrayList<>();
        try (Connection conn = MysqlConfig.getConnection()) {
            try {
                PreparedStatement statement = conn.prepareStatement(query);

                // parameterIndex starts from 1 from the left
                statement.setInt(1, id);

                // convert result set objects to user class
                objLst = new ArrayList<>();

                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    TaskEntity obj = new TaskEntity();

                    obj.setId(rs.getInt("id"));
                    obj.setName(rs.getString("name"));
                    obj.setStartDate(rs.getString("start_date"));
                    obj.setEndDate(rs.getString("end_date"));
                    obj.setProjectName(rs.getString("project_name"));
                    obj.setStatusName(rs.getString("status_name"));
                    obj.setStatusColor(rs.getString("status_color"));
                    obj.setUserFullName(rs.getString("user_name"));

                    objLst.add(obj);
                }
            } catch (SQLException e) {
                System.out.println("TaskRepo: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("TaskRepo: Failed to close connection. " + e.getMessage());
        }

        return Optional.ofNullable(objLst.isEmpty() ? null : objLst.getFirst());
    }


    public int save(TaskEntity obj) {
        int updatedRow = 0;

        String query = """
            INSERT INTO tasks(name, start_date, end_date, user_id, project_id, status_id) VALUES (?, ?, ?, ?, ?, ?)
            """;
        try (Connection conn = MysqlConfig.getConnection()) {
            try {
                PreparedStatement stmt = conn.prepareStatement(query);

                stmt.setString(1, obj.getName());
                stmt.setDate(2, Date.valueOf(obj.getStartDate()));
                stmt.setDate(3, Date.valueOf(obj.getEndDate()));
                stmt.setInt(4, obj.getUserId());
                stmt.setInt(5, obj.getProjectId());
                stmt.setInt(6, obj.getStatusId());

                updatedRow = stmt.executeUpdate();
            } catch (Exception e) {
                System.out.println("TaskRepo: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("TaskRepo: Failed to close connection. " + e.getMessage());

        }

        return updatedRow;
    }


    public int update(TaskEntity obj) {
        int updatedRow = 0;

        String query = """
            UPDATE tasks
            SET name = ?, start_date = ?, end_date = ?,
                user_id = ?, project_id = ?, status_id = ?
            WHERE id = ?
            """;

        try (Connection conn = MysqlConfig.getConnection()) {
            try {
                PreparedStatement stmt = conn.prepareStatement(query);

                stmt.setString(1, obj.getName());
                stmt.setDate(2, Date.valueOf(obj.getStartDate()));
                stmt.setDate(3, Date.valueOf(obj.getEndDate()));
                stmt.setInt(4, obj.getUserId());
                stmt.setInt(5, obj.getProjectId());
                stmt.setInt(6, obj.getStatusId());
                stmt.setInt(7, obj.getId());

                updatedRow = stmt.executeUpdate();

            } catch (Exception e) {
                System.out.println("TaskRepo: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("TaskRepo: Failed to close connection. " + e.getMessage());
        }
        return updatedRow;
    }


    public int deleteById(int id) {
        int removedRow = 0;

        String query = """
            DELETE
            FROM tasks
            WHERE id = ?
            """;

        try (Connection conn = MysqlConfig.getConnection()) {
            try {
                PreparedStatement stmt = conn.prepareStatement(query);

                stmt.setInt(1, id);
                removedRow = stmt.executeUpdate();

            } catch (Exception e) {
                System.out.println("TaskRepo: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("TaskRepo: Failed to close connection. " + e.getMessage());
        }
        return removedRow;
    }


    public List<TaskStatusCountDTO> findTaskByUserStatus() {
        List<TaskStatusCountDTO> objLst = new ArrayList<>();

        String query = """
                SELECT st.name, st.color, COUNT(t.status_id) AS 'num_task'
                FROM tasks t
                    RIGHT JOIN status st ON t.status_id = st.id
                GROUP BY t.status_id, st.name, st.color;
            """;

        try (Connection conn = MysqlConfig.getConnection()) {
            try {
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    TaskStatusCountDTO obj = new TaskStatusCountDTO();

                    obj.setName(rs.getString("name"));
                    obj.setColor(rs.getString("color"));
                    obj.setNumTask(rs.getLong("num_task"));

                    objLst.add(obj);
                }
            } catch (SQLException e) {
                System.out.println("TaskRepo: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("TaskRepo: Failed to close connection. " + e.getMessage());
        }
        return objLst;
    }


    public Optional<UserTaskStatusStatsDTO> findTaskByUserStatus(Integer userId) {
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
                        (COUNT(t.id) / NULLIF(SUM(COUNT(t.id)) OVER(), 0)) * 100,
                        0.00
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
                    List<UserTaskStatusDetailDTO> userTaskDetailsList = mapper.readValue(taskDetailsJson, new TypeReference<>() {
                    });

                    obj.getTaskStatusDetailMap().put(statusName, userTaskDetailsList);
                }
            } catch (SQLException e) {
                System.out.println("TaskRepo: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("TaskRepo: Failed to close connection. " + e.getMessage());
        }
        return Optional.ofNullable(obj);
    }
}
