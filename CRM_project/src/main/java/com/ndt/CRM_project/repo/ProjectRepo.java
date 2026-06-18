package com.ndt.CRM_project.repo;

import java.sql.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;


import com.ndt.CRM_project.dto.project.ProjectTaskStatusStatsDTO;
import com.ndt.CRM_project.dto.task.UserTaskStatusDetailDTO;
import com.ndt.CRM_project.dto.task.UserTaskStatusStatsDTO;
import com.ndt.CRM_project.utils.MysqlConfig;
import com.ndt.CRM_project.entity.ProjectEntity;

import tools.jackson.core.JacksonException;
import tools.jackson.core.type.TypeReference;


/**
 * Quản lý tất cả câu query liên quan tới bảng role
 */
public class ProjectRepo {
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
        ProjectTaskStatusStatsDTO obj = null;

        String query = """
            SELECT u.id                                                  AS 'user_id',
                   u.fullname,
                   u.email,
                   st.name                                               AS 'status_name',
                   st.color,
                   SUM(COUNT(t.id)) OVER ()                              AS total_task,
                   SUM(COUNT(t.id)) OVER (PARTITION BY st.id)            AS 'total_task_by_status',
                   IFNULL(ROUND(SUM(COUNT(t.id)) OVER (PARTITION BY st.id) / NULLIF(SUM(COUNT(t.id)) OVER (), 0) * 100, 2), 0.)
                                                                         AS 'task_status_rate',
                   SUM(COUNT(t.id)) OVER (PARTITION BY t.user_id)        AS 'total_task_by_status_by_user',
                   SUM(COUNT(t.id)) OVER (PARTITION BY t.user_id, st.id) AS 'total_task_by_status_by_user',
                   IFNULL(ROUND(COUNT(t.id) / NULLIF(SUM(COUNT(t.id)) OVER (PARTITION BY t.user_id), 0) * 100, 2), 0.)
                                                                         AS 'task_status_rate_by_user',
                   IF(COUNT(t.id) = 0, JSON_ARRAY(),
                      JSON_ARRAYAGG(
                              JSON_OBJECT(
                                      'task_id', t.id,
                                      'task_name', t.name,
                                      'start_date', t.start_date,
                                      'end_date', t.end_date
                              )
                      )
                   )                                                     AS task_details
              FROM users u
                       CROSS JOIN status st
                       LEFT JOIN tasks t ON t.user_id = u.id AND t.status_id = st.id
              WHERE t.project_id = ?
              GROUP BY u.id, u.fullname, u.email, t.project_id, st.id, st.name, st.color
              ORDER BY u.id;
            """;

        try (Connection conn = MysqlConfig.getConnection()) {
            try {
                PreparedStatement stmt = conn.prepareStatement(query);

                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();

                Integer prevUserId = -1;
                UserTaskStatusStatsDTO userObj = null;
                while (rs.next()) {
                    // Build ProjectTaskStatusStatsDTO
                    if (obj == null) {
                        obj = new ProjectTaskStatusStatsDTO();

                        obj.setProjectId(id);
                        obj.setTotalTask(rs.getInt("total_task"));

                        // obj.setUserId(rs.getInt(userId));
                        // obj.setFullName(rs.getString("fullname"));
                        // obj.setEmail(rs.getString("email"));
                        // obj.setTotalTasks(rs.getInt("total_tasks"));
                    }

                    String statusName = rs.getString("status_name");
                    if (!obj.getTaskStatusMap().containsKey(statusName)) {
                        obj.getTaskStatusMap().put(statusName, rs.getInt("total_tasks_by_status"));
                        obj.getTaskStatusRateMap().put(statusName, rs.getDouble("task_status_rate"));
                    }

                    // Build UserTaskStatusStatsDTO
                    Integer curUserId = rs.getInt("user_id");

                    if (!curUserId.equals(prevUserId)) {
                        userObj = new UserTaskStatusStatsDTO();
                    }




                    String taskDetailsJson = rs.getString("task_details");
                    // List<UserTaskStatusDetailDTO> userTaskDetailsList = mapper.readValue(
                    //     taskDetailsJson,
                    //     new TypeReference<>() {
                    //         // Jackson's solution to Java's type erasure problem by using anonymous subclass
                    //     }
                    // );
                    //
                    // obj.getTaskStatusDetailMap().put(statusName, userTaskDetailsList);
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
