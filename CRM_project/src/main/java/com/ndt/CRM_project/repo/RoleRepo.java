package com.ndt.CRM_project.repo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;


import com.mysql.cj.jdbc.exceptions.ConnectionFeatureNotAvailableException;
import com.ndt.CRM_project.entity.RoleEntity;
import com.ndt.CRM_project.utils.MysqlConfig;
import jakarta.ejb.ApplicationException;


/**
 * Quản lý tất cả câu query liên quan tới bảng role
 */
public class RoleRepo {
    public List<RoleEntity> findAll() {
        List<RoleEntity> roles = new ArrayList<>();

        String query = "SELECT * FROM roles";

        try (Connection conn = MysqlConfig.getConnection()) {
            try {
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    RoleEntity role = new RoleEntity();

                    role.setId(rs.getInt("id"));
                    role.setName(rs.getString("name"));
                    role.setDescription(rs.getString("description"));

                    roles.add(role);
                }
            } catch (SQLException e) {
                System.out.println("RoleRepo: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("RoleRepo: Failed to close connection. " + e.getMessage());
        }
        return roles;
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
}
