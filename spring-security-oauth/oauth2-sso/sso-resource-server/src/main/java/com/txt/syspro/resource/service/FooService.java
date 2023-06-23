package com.txt.syspro.resource.service;

import java.util.Optional;

import com.txt.syspro.resource.entities.Foo;

public interface FooService {
    Optional<Foo> findById(Long id);

    Foo save(Foo foo);

    Iterable<Foo> findAll();
}