package com.ndt.CRM_project.repo;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import com.ndt.CRM_project.entity.TaskEntity;
import com.ndt.CRM_project.utils.MysqlConfig;


/**
 * Quản lý tất cả câu query liên quan tới bảng role
 */
public class TaskRepo {
    public List<TaskEntity> findAll() {
        List<TaskEntity> objLst = new ArrayList<>();

        String query = """
                SELECT t.id, t.name, t.start_date, t.end_date,
                       prj.name AS 'project_name',
                       st.name AS 'status_name',
                       u.fullname AS 'user_name'
                FROM tasks t
                    JOIN projects prj ON t.project_id = prj.id
                    JOIN status st ON t.status_id = st.id
                    JOIN users u ON t.user_id = u.id
            """;

        try {
            Connection conn = MysqlConfig.getConnection();
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
                obj.setUserFullname(rs.getString("user_name"));

                objLst.add(obj);
            }
        } catch (Exception e) {
            System.out.println("TaskRepo: " + e.getMessage());
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
