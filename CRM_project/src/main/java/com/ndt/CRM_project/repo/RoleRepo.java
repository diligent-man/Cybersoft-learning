package com.ndt.CRM_project.repo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;


import com.ndt.CRM_project.entity.RoleEntity;
import com.ndt.CRM_project.utils.MysqlConfig;


/**
 * Quản lý tất cả câu query liên quan tới bảng role
 */
public class RoleRepo {
    public List<RoleEntity> findAll() {
        List<RoleEntity> objLst = new ArrayList<>();

        String query = "SELECT * FROM roles";

        try (Connection conn = MysqlConfig.getConnection()) {
            try {
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    RoleEntity obj = new RoleEntity();

                    obj.setId(rs.getInt("id"));
                    obj.setName(rs.getString("name"));
                    obj.setDescription(rs.getString("description"));

                    objLst.add(obj);
                }
            } catch (SQLException e) {
                System.out.println("RoleRepo: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("RoleRepo: Failed to close connection. " + e.getMessage());
        }
        return objLst;
    }


    public Optional<RoleEntity> findById(int id) {
        String query = """
            SELECT *
            FROM roles
            WHERE id=?
            """;

        List<RoleEntity> objLst = new ArrayList<>();
        try (Connection conn = MysqlConfig.getConnection()) {
            try {
                PreparedStatement stmt = conn.prepareStatement(query);

                stmt.setInt(1, id);

                objLst = new ArrayList<>();

                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    RoleEntity obj = new RoleEntity();

                    obj.setId(Integer.parseInt(rs.getString("id")));
                    obj.setName(rs.getString("name"));
                    obj.setDescription(rs.getString("description"));

                    objLst.add(obj);
                }
            } catch (SQLException e) {
                System.out.println("RoleRepo: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("RoleRepo: Failed to close connection. " + e.getMessage());
        }

        return Optional.ofNullable(objLst.isEmpty() ? null : objLst.getFirst());
    }


    public int save(RoleEntity obj) {
        int updatedRow = 0;

        String query = """
            INSERT INTO roles(name, description) VALUES (?, ?)
            """;

        try (Connection conn = MysqlConfig.getConnection()) {
            try {
                PreparedStatement stmt = conn.prepareStatement(query);

                stmt.setString(1, obj.getName());
                stmt.setString(2, obj.getDescription());

                updatedRow = stmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println("RoleRepo: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("RoleRepo: Failed to close connection. " + e.getMessage());
        }
        return updatedRow;
    }


    public int update(RoleEntity obj) {
        int updatedRow = 0;

        String query = """
            UPDATE roles
            SET name = ?, description = ?
            WHERE id = ?
            """;

        try (Connection conn = MysqlConfig.getConnection()) {
            try {
                PreparedStatement stmt = conn.prepareStatement(query);

                stmt.setString(1, obj.getName());
                stmt.setString(2, obj.getDescription());
                stmt.setInt(3, obj.getId());

                updatedRow = stmt.executeUpdate();

            } catch (Exception e) {
                System.out.println("RoleRepo: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("RoleRepo: Failed to close connection. " + e.getMessage());
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
                System.out.println("RoleRepo: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("RoleRepo: Failed to close connection. " + e.getMessage());
        }
        return removedRow;
    }

}
