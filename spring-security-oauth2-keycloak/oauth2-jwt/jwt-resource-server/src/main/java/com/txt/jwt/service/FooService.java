package com.txt.jwt.service;

import java.util.Optional;

import com.txt.jwt.entities.Foo;


public interface FooService {

    Optional<Foo> findById(Long id);

    Foo save(Foo foo);

    Iterable<Foo> findAll();
}
