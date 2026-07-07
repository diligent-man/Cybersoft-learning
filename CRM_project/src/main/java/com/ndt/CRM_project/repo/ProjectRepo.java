package com.ndt.CRM_project.repo;

import java.sql.*;
import java.sql.Date;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;


import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.core.type.TypeReference;

import com.ndt.CRM_project.utils.MysqlConfig;
import com.ndt.CRM_project.entity.ProjectEntity;

import com.ndt.CRM_project.dto.project.UserTaskDetailDTO;
import com.ndt.CRM_project.dto.project.UserTaskStatusStatsDTO;
import com.ndt.CRM_project.dto.project.ProjectTaskStatusStatsDTO;


/**
 * Quản lý tất cả câu query liên quan tới bảng role
 */
public class ProjectRepo {
    private final ObjectMapper mapper = new ObjectMapper();


    public List<ProjectEntity> findAll() {
        List<ProjectEntity> objLst = new ArrayList<>();

        String query = "SELECT * FROM projects";

        try (Connection conn = MysqlConfig.getConnection()) {
            try {
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    ProjectEntity obj = new ProjectEntity();

                    obj.setId(rs.getInt("id"));
                    obj.setName(rs.getString("name"));
                    obj.setStartDate(rs.getString("start_date"));
                    obj.setEndDate(rs.getString("end_date"));

                    objLst.add(obj);
                }
            } catch (SQLException e) {
                System.out.println("ProjectRepo: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("RoleRepo: Failed to close connection. " + e.getMessage());
        }

        return objLst;
    }


    public Optional<ProjectEntity> findById(int id) {
        String query = """
            SELECT *
            FROM projects
            WHERE id=?
            """;

        List<ProjectEntity> objLst = new ArrayList<>();
        try (Connection conn = MysqlConfig.getConnection()) {
            try {
                PreparedStatement statement = conn.prepareStatement(query);

                // parameterIndex starts from 1 from the left
                statement.setInt(1, id);

                // convert result set objects to user class
                objLst = new ArrayList<>();

                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    ProjectEntity obj = new ProjectEntity();

                    obj.setId(rs.getInt("id"));
                    obj.setName(rs.getString("name"));
                    obj.setStartDate(rs.getString("start_date"));
                    obj.setEndDate(rs.getString("end_date"));

                    objLst.add(obj);
                }
            } catch (SQLException e) {
                System.out.println("ProjectRepo: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("ProjectRepo: Failed to close connection. " + e.getMessage());
        }

        return Optional.ofNullable(objLst.isEmpty() ? null : objLst.getFirst());
    }


    public int save(ProjectEntity obj) {
        int updatedRow = 0;

        String query = """
            INSERT INTO projects(name, start_date, end_date) VALUES (?, ?, ?)
            """;

        try (Connection conn = MysqlConfig.getConnection()) {
            try {
                PreparedStatement stmt = conn.prepareStatement(query);

                stmt.setString(1, obj.getName());
                stmt.setDate(2, Date.valueOf(obj.getStartDate()));
                stmt.setDate(3, Date.valueOf(obj.getEndDate()));

                updatedRow = stmt.executeUpdate();
            } catch (Exception e) {
                System.out.println("ProjectRepo: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("ProjectRepo: Failed to close connection. " + e.getMessage());
        }
        return updatedRow;
    }


    public int update(ProjectEntity obj) {
        int updatedRow = 0;

        String query = """
            UPDATE projects
            SET name = ?, start_date = ?, end_date = ?
            WHERE id = ?
            """;

        try (Connection conn = MysqlConfig.getConnection()) {
            try {
                PreparedStatement stmt = conn.prepareStatement(query);

                stmt.setString(1, obj.getName());
                stmt.setDate(2, Date.valueOf(obj.getStartDate()));
                stmt.setDate(3, Date.valueOf(obj.getEndDate()));
                stmt.setInt(4, obj.getId());

                updatedRow = stmt.executeUpdate();

            } catch (Exception e) {
                System.out.println("ProjectRepo: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("ProjectRepo: Failed to close connection. " + e.getMessage());
        }
        return updatedRow;
    }


    public int delete(int id) {
        int removedRow = 0;

        String query = """
            DELETE
            FROM roles
            WHERE id = ?
            """;

        try (Connection conn = MysqlConfig.getConnection()) {
            try {
                PreparedStatement stmt = conn.prepareStatement(query);

                stmt.setInt(1, id);
                removedRow = stmt.executeUpdate();

            } catch (Exception e) {
                System.out.println("ProjectRepo: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("ProjectRepo: Failed to close connection. " + e.getMessage());
        }
        return removedRow;
    }


    public Optional<ProjectTaskStatusStatsDTO> findProjectStatusById(int id) {
        String query = """
            WITH UserInProject AS (
                SELECT
                    COALESCE(t.project_id, 1)            AS 'project_id',
                    t.id                                 AS 'task_id',
                    t.name                               AS 'task_name',
                    COALESCE(t.user_id, u.id)            AS 'user_id',
                    u.fullname,
                    st.name                              AS 'status_name',
                    st.color                             AS 'status_color',
                    t.submit_message,
                    t.submit_time,
                    COUNT(t.id) OVER (PARTITION BY u.id) AS 'task_count'
                FROM users u
                         CROSS JOIN status st
                         LEFT JOIN tasks t ON t.user_id = u.id AND
                                              t.status_id = st.id AND
                                              t.project_id = ?
                ORDER BY t.user_id, t.id
            )
            SELECT project_id, user_id, fullname, status_name, status_color,
                   IFNULL(SUM(COUNT(task_id)) OVER (PARTITION BY status_name), 0) AS 'total_task_by_status',
                   IFNULL(ROUND(SUM(COUNT(task_id)) OVER (PARTITION BY status_name) / NULLIF(SUM(COUNT(task_id)) OVER (), 0) * 100, 2), 0.) AS 'task_status_rate',
                   SUM(COUNT(task_id)) OVER (PARTITION BY user_id, status_name) AS 'user_total_task_by_status',
                   IFNULL(ROUND(COUNT(task_id) / NULLIF(SUM(COUNT(task_id)) OVER (PARTITION BY user_id), 0) * 100, 2), 0.) AS 'user_task_status_rate',
                   IF(COUNT(task_id) = 0, JSON_ARRAY(),
                      JSON_ARRAYAGG(
                              JSON_OBJECT(
                                      'task_id', task_id,
                                      'task_name', task_name,
                                      'submit_message', submit_message,
                                      'submit_time', submit_time
                              )
                      )
                   )                                                     AS task_details
            FROM UserInProject
            WHERE task_count > 0
            GROUP BY project_id, user_id, fullname, status_name, status_name, status_color
            ORDER BY user_id;
            """;

        ProjectTaskStatusStatsDTO projectStatusStatsDTO = null;

        try (Connection conn = MysqlConfig.getConnection()) {
            try {
                PreparedStatement stmt = conn.prepareStatement(query);

                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();

                UserTaskStatusStatsDTO userTaskStatusStatsDTO = null;

                int prevUserid = -1;
                while (rs.next()) {
                    // Build ProjectTaskStatusStatsDTO
                    if (projectStatusStatsDTO == null) {
                        projectStatusStatsDTO = new ProjectTaskStatusStatsDTO();

                        projectStatusStatsDTO.setProjectId(id);
                    }

                    // Build project's BaseTaskStatusModel
                    String statusName = rs.getString("status_name");
                    if (!projectStatusStatsDTO.getTaskStatusTotalMap().containsKey(statusName)) {
                        projectStatusStatsDTO.getTaskStatusTotalMap().put(statusName, rs.getInt("total_task_by_status"));
                        projectStatusStatsDTO.getTaskStatusRateMap().put(statusName, rs.getDouble("task_status_rate"));
                        projectStatusStatsDTO.getTaskColorMap().put(statusName, rs.getString("status_color"));
                    }

                    // Build List<UserTaskStatusStatsDTO>
                    int userId = rs.getInt("user_id");
                    if (prevUserid != userId) {
                        if (userTaskStatusStatsDTO != null)
                            projectStatusStatsDTO.getUserTaskStatusStatsList().add(userTaskStatusStatsDTO);

                        userTaskStatusStatsDTO = new UserTaskStatusStatsDTO();

                        userTaskStatusStatsDTO.setUserId(userId);
                        userTaskStatusStatsDTO.setFullName(rs.getString("fullname"));

                        prevUserid = userId;
                    }

                    // Build List<UserTaskDetailDTO>
                    if (!userTaskStatusStatsDTO.getTaskStatusTotalMap().containsKey(statusName)) {
                        userTaskStatusStatsDTO.getTaskStatusTotalMap().put(statusName, rs.getInt("user_total_task_by_status"));
                        userTaskStatusStatsDTO.getTaskStatusRateMap().put(statusName, rs.getDouble("user_task_status_rate"));
                        userTaskStatusStatsDTO.getTaskColorMap().put(statusName, rs.getString("status_color"));

                        String taskDetailJson = rs.getString("task_details");
                        List<UserTaskDetailDTO> userTaskDetailList = mapper.readValue(
                            taskDetailJson,
                            new TypeReference<>() {
                                // Jackson's solution to Java's type erasure problem by using anonymous subclass
                            }
                        );

                        userTaskStatusStatsDTO.getTaskStatusDetailMap().put(statusName, userTaskDetailList);
                    }
                }

                // add last user
                if (projectStatusStatsDTO != null) {
                    projectStatusStatsDTO.getUserTaskStatusStatsList().add(userTaskStatusStatsDTO);
                }

            } catch (SQLException e) {
                System.out.println("TaskRepo: " + e.getMessage());
            } catch (JacksonException e) {
                System.out.println("TaskRepo - Jackson: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("TaskRepo: Failed to close connection. " + e.getMessage());
        }
        return Optional.ofNullable(projectStatusStatsDTO);
    }
}
