package com.ndt.spring.day_40.entity;

import java.util.List;


import jakarta.persistence.*;


import lombok.*;




@Setter
@Getter
@ToString
@Entity(name = "roles")
public class RoleEntity {
    @Id
    private Integer id;

    private String name;

    // Sol 1: use @JsonIgnore to ignore this field during serialization (can be in 1 side or N side)
    // @JsonIgnore
    @OneToMany(mappedBy = "role")
    private List<UserEntity> users;
}
