package com.ndt.CRM_project.repo;

import java.sql.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;


import com.ndt.CRM_project.utils.MysqlConfig;
import com.ndt.CRM_project.entity.ProjectEntity;


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
}
