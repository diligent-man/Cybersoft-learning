package com.ndt.CRM_project.repo;

import java.sql.*;
import java.sql.PreparedStatement;

import java.util.List;
import java.util.ArrayList;

import com.ndt.CRM_project.entity.TaskEntity;
import com.ndt.CRM_project.utils.MysqlConfig;
import com.ndt.CRM_project.dto.TaskStatusCount;


/**
 * Quản lý tất cả câu query liên quan tới bảng role
 */
public class TaskRepo {
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
                    obj.setUserFullname(rs.getString("user_name"));

                    objLst.add(obj);
                }
            } catch (SQLException e) {
                System.out.println("TaskRepo: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("RoleRepo: Failed to close connection. " + e.getMessage());
        }
        return objLst;
    }


    public List<TaskStatusCount> findTaskByStatus() {
        List<TaskStatusCount> objLst = new ArrayList<>();

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
                    TaskStatusCount obj = new TaskStatusCount();

                    obj.setName(rs.getString("name"));
                    obj.setColor(rs.getString("color"));
                    obj.setNumTask(rs.getLong("num_task"));

                    objLst.add(obj);
                }
            } catch (SQLException e) {
                System.out.println("TaskRepo: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("RoleRepo: Failed to close connection. " + e.getMessage());
        }
        return objLst;
    }

    // public int save(ProjectEntity obj) {
    //     int updatedRow = 0;
    //
    //     String query = """
    //         INSERT INTO projects(name, start_date, end_date) VALUES (?, ?, ?)
    //         """;
    //
    //     try {
    //         Connection conn = MysqlConfig.getConnection();
    //         PreparedStatement stmt = conn.prepareStatement(query);
    //
    //         stmt.setString(1, obj.getName());
    //         stmt.setDate(2, Date.valueOf(obj.getStartDate()));
    //         stmt.setDate(3, Date.valueOf(obj.getEndDate()));
    //
    //         updatedRow = stmt.executeUpdate();
    //     } catch (Exception e) {
    //         System.out.println("ProjectRepo: " + e.getMessage());
    //     }
    //     return updatedRow;
    // }
}
