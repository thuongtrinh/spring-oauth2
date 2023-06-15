package com.txt.auth.jwt.repositories;

import com.txt.auth.jwt.entities.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
