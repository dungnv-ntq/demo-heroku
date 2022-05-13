package com.dung.demoheroku;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class HelloController {

    @Autowired
    private StudentRepository repository;

    @Autowired
    private StudentMapper mapper;

    @GetMapping("/hello")
    public String hello() {
        return "Hello world from heroku";
    }

    @GetMapping("/students")
    public List<StudentDto> getAll() {
        return repository.findAll().stream().map(entity -> mapper.toDto(entity)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public StudentDto findById(@PathVariable Integer id) {
        StudentEntity entity =  repository.findById(id).orElse(null);
        return mapper.toDto(entity);
    }
}
