package com.txt.auth.jwt.repositories;

import com.txt.auth.jwt.entities.RandomCity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RandomCityRepository extends JpaRepository<RandomCity, Long> {
}
