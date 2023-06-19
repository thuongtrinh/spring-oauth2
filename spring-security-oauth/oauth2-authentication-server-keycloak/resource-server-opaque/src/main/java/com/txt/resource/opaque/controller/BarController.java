package com.txt.resource.opaque.controller;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

import java.util.ArrayList;
import java.util.List;

import com.txt.resource.opaque.entities.Bar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/bars")
public class BarController {

    private static final Logger logger = LoggerFactory.getLogger(BarController.class);

    @GetMapping(value = "/{id}")
    public Bar findOne(@PathVariable Long id) {
        return new Bar(Long.parseLong(randomNumeric(2)), randomAlphabetic(4));
    }

    @GetMapping
    public List<Bar> findAll() {
        List<Bar> barList = new ArrayList<Bar>();
        barList.add(new Bar(Long.parseLong(randomNumeric(2)), randomAlphabetic(4)));
        barList.add(new Bar(Long.parseLong(randomNumeric(2)), randomAlphabetic(4)));
        barList.add(new Bar(Long.parseLong(randomNumeric(2)), randomAlphabetic(4)));
        return barList;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@RequestBody Bar newBar) {
        logger.info("Bar created");
    }

}