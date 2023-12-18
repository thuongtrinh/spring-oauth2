package com.txt.syspro.resource.service.impl;

import java.util.Optional;

import com.txt.syspro.resource.entities.Foo;
import com.txt.syspro.resource.repositories.FooRepository;
import com.txt.syspro.resource.service.FooService;
import org.springframework.stereotype.Service;

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
