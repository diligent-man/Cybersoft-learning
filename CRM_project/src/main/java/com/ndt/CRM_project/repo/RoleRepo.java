package com.ndt.CRM_project.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;


import com.ndt.CRM_project.entity.RoleEntity;
import com.ndt.CRM_project.utils.MysqlConfig;


/**
 * Quản lý tất cả câu query liên quan tới bảng role
 */
public class RoleRepo {
    public List<RoleEntity> findAll() {
        List<RoleEntity> roles = new ArrayList<>();

        String query = "SELECT * FROM roles";

        try {
            Connection conn = MysqlConfig.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                RoleEntity role = new RoleEntity();

                role.setId(rs.getInt("id"));
                role.setName(rs.getString("name"));
                role.setDescription(rs.getString("description"));

                roles.add(role);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        return roles;
    }
}
