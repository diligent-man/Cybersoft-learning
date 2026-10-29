package com.ndt.bookshop_authentication.repo;

import java.util.Optional;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.ndt.bookshop_authentication.entity.Users;


@Repository
public interface UserRepo extends JpaRepository<Users, String> {
    Optional<Users> findByEmail(String email);
}
