package com.txt.jwt.controller;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.txt.jwt.service.FooService;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.txt.jwt.entities.Foo;
import com.txt.jwt.dto.FooDTO;

@RestController
@RequestMapping(value = "/api/foos")
@CrossOrigin(origins = "*")
public class FooController {

    private FooService fooService;

    public FooController(FooService fooService) {
        this.fooService = fooService;
    }

    @GetMapping(value = "/{id}")
    public FooDTO findOne(@PathVariable Long id) {
        return new FooDTO(Long.parseLong(randomNumeric(2)), randomAlphabetic(4));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@RequestBody FooDTO newFoo) {
        Foo entity = convertToEntity(newFoo);
        this.fooService.save(entity);
    }

    @GetMapping
    public Collection<FooDTO> findAll() {
        Iterable<Foo> foos = this.fooService.findAll();
        List<FooDTO> fooDTOS = new ArrayList<>();
        foos.forEach(p -> fooDTOS.add(convertToDto(p)));
        return fooDTOS;
    }

    @PutMapping("/{id}")
    public FooDTO updateFoo(@PathVariable("id") Long id, @RequestBody FooDTO updatedFoo) {
        Foo fooEntity = convertToEntity(updatedFoo);
        return this.convertToDto(this.fooService.save(fooEntity));
    }

    protected FooDTO convertToDto(Foo entity) {
        FooDTO dto = new FooDTO(entity.getId(), entity.getName());

        return dto;
    }

    protected Foo convertToEntity(FooDTO dto) {
        Foo foo = new Foo(dto.getName());
        if (!StringUtils.isEmpty(dto.getId())) {
            foo.setId(dto.getId());
        }
        return foo;
    }
}