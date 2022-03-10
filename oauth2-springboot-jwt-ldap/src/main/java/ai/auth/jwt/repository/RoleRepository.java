package ai.auth.jwt.repository;

import ai.auth.jwt.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {
}
