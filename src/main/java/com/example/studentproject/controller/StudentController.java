package com.example.studentproject.controller;

import com.example.studentproject.payload.StudentDto;
import com.example.studentproject.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/student")

public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity createNewStudent(@RequestBody StudentDto studentDto) {

        StudentDto student = studentService.createStudent(studentDto);

        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PutMapping("{/id}")
    public ResponseEntity updateStudent(@RequestBody StudentDto studentDto, @PathVariable("id") long id) {
        StudentDto studentDto1 = studentService.updateNewStudent(studentDto, id);

        return new ResponseEntity<>(studentDto1, HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<StudentDto> getById(@PathVariable("id") long id) {
        StudentDto dto = studentService.getByStudentId(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);///http status return back to api  mean postman
    }

    @DeleteMapping("/id")
    public ResponseEntity<String> deleteById(@PathVariable("id") long id) {


        studentService.deleteByStudentId(id);

        return new ResponseEntity<String>("deleted the student  record successfuly ", HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<StudentDto> getAllStudentId() {
        studentService.getALLStudents();
        return new ResponseEntity<>(HttpStatus.OK);



    }
}
