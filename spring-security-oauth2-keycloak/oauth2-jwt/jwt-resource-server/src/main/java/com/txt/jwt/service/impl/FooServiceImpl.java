package com.txt.jwt.service.impl;

import java.util.Optional;

import com.txt.jwt.repositories.FooRepository;
import com.txt.jwt.service.FooService;
import org.springframework.stereotype.Service;

import com.txt.jwt.entities.Foo;

@Service
public class FooServiceImpl implements FooService {

    private FooRepository fooRepository;

    public FooServiceImpl(FooRepository fooRepository) {
        this.fooRepository = fooRepository;
    }

    @Override
    public Optional<Foo> findById(Long id) {
        return fooRepository.findById(id);
    }

    @Override
    public Foo save(Foo foo) {
        return fooRepository.save(foo);
    }

    @Override
    public Iterable<Foo> findAll() {
        return fooRepository.findAll();
    }
}
