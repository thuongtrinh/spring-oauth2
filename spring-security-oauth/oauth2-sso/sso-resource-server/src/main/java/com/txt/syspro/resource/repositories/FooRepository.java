package com.txt.syspro.resource.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.txt.syspro.resource.entities.Foo;

public interface FooRepository extends PagingAndSortingRepository<Foo, Long> {
}
