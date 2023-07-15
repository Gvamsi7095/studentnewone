package com.example.studentproject.service;

import com.example.studentproject.payload.StudentDto;

import java.util.List;

public interface StudentService {


StudentDto createStudent(StudentDto studentDto);

    StudentDto updateNewStudent(StudentDto studentDto, long id);

    StudentDto getByStudentId(long id);

    void deleteByStudentId(long id);

   List<StudentDto > getALLStudents();
}
