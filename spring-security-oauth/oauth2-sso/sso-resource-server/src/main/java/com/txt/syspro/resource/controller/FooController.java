package com.txt.syspro.resource.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.txt.syspro.resource.service.FooService;
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
import org.springframework.web.server.ResponseStatusException;

import com.txt.syspro.resource.entities.Foo;
import com.txt.syspro.resource.dto.FooDTO;

@RestController
@RequestMapping(value = "/api/foos")
public class FooController {

    private FooService fooService;

    public FooController(FooService fooService) {
        this.fooService = fooService;
    }

    @CrossOrigin(origins = "http://localhost:8089")
    @GetMapping(value = "/{id}")
    public FooDTO findOne(@PathVariable Long id) {
        Foo entity = fooService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return convertToDto(entity);
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