package com.txt.auth.jwt.service;

import com.txt.auth.jwt.entities.RandomCity;
import com.txt.auth.jwt.entities.auth.User;

import java.util.List;

public interface GenericService {
    User findByUsername(String username);

    List<User> findAllUsers();

    List<RandomCity> findAllRandomCities();
}
