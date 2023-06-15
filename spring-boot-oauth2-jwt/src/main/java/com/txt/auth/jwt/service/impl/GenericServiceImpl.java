package com.txt.auth.jwt.service.impl;

import com.txt.auth.jwt.entities.RandomCity;
import com.txt.auth.jwt.entities.auth.User;
import com.txt.auth.jwt.repositories.RandomCityRepository;
import com.txt.auth.jwt.repositories.UserRepository;
import com.txt.auth.jwt.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenericServiceImpl implements GenericService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RandomCityRepository randomCityRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<RandomCity> findAllRandomCities() {
        return randomCityRepository.findAll();
    }
}
