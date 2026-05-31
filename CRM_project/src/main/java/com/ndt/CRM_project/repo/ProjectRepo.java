package com.ndt.CRM_project.repo;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import com.ndt.CRM_project.utils.MysqlConfig;
import com.ndt.CRM_project.entity.ProjectEntity;


/**
 * Quản lý tất cả câu query liên quan tới bảng role
 */
public class ProjectRepo {
    public List<ProjectEntity> findAll() {
        List<ProjectEntity> objLst = new ArrayList<>();

        String query = "SELECT * FROM projects";
        DateTimeFormatter parseFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.of("vi", "VN"));

        try {
            Connection conn = MysqlConfig.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ProjectEntity obj = new ProjectEntity();

                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setStartDate(LocalDate.parse(rs.getString("start_date"), parseFormatter));
                obj.setEndDate(LocalDate.parse(rs.getString("end_date"), parseFormatter));

                objLst.add(obj);
            }
        } catch (Exception e) {
            System.out.println("RoleRepo: " + e.getMessage());
        }

        return objLst;
    }


    public int save(ProjectEntity obj) {
        int updatedRow = 0;

        String query = """
            INSERT INTO projects(name, start_date, end_date) VALUES (?, ?, ?)
            """;

        try {
            Connection conn = MysqlConfig.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, obj.getName());
            stmt.setDate(2, Date.valueOf(obj.getStartDate()));
            stmt.setDate(3, Date.valueOf(obj.getEndDate()));

            updatedRow = stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("GroupworkRepo: " + e.getMessage());
        }
        return updatedRow;
    }
}
