package com.dung.demoheroku;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/students/{id}")
    public ResponseEntity findById(@PathVariable Integer id) {
        StudentEntity entity =  repository.findById(id).orElse(null);
        return ResponseEntity.ok(mapper.toDto(entity));
    }

    @PostMapping("/students")
    public ResponseEntity createStudent(@RequestBody StudentDto studentDto) {
        return ResponseEntity.ok(repository.save(mapper.toEntity(studentDto)));
    }
}
