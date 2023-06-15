package ai.auth.jwt.service;

import ai.auth.jwt.domain.RandomCity;
import ai.auth.jwt.domain.User;

import java.util.List;

public interface GenericService {
    User findByUsername(String username);

    List<User> findAllUsers();

    List<RandomCity> findAllRandomCities();
}
