package ai.auth.jwt.repository;

import ai.auth.jwt.domain.RandomCity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RandomCityRepository extends JpaRepository<RandomCity, Long> {
}
