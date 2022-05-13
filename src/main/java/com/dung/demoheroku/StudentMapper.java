package com.dung.demoheroku;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper{
    StudentDto toDto(StudentEntity entity);

    StudentEntity toEntity(StudentDto dto);
}
