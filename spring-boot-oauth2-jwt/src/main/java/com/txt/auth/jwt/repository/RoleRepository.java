package com.txt.auth.jwt.repository;

import com.txt.auth.jwt.entities.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {
}
