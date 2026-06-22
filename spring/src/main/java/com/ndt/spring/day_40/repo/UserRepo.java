package com.ndt.spring.day_40.repo;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.Param;


import com.ndt.spring.day_40.entity.UserEntity;


@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findAll();

    UserEntity findByEmailAndPassword(String email, String password);


    @Query("""
            SELECT u
            FROM users u
            WHERE u.email = :email AND u.password = :password
        """)
    Optional<UserEntity> kiemTraEmailPassword(@Param("email") String email,
                                              @Param("password") String password);
}
