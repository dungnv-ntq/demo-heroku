package com.dung.demoheroku;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class StudentDto {
    private Integer id;
    private String name;
    private Integer age;
}
