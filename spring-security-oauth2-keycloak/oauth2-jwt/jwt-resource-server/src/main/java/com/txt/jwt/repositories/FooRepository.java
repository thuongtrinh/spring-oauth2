package com.txt.jwt.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.txt.jwt.entities.Foo;

public interface FooRepository extends PagingAndSortingRepository<Foo, Long> {
}
