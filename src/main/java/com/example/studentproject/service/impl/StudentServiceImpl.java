package com.example.studentproject.service.impl;

import com.example.studentproject.entity.Student;
import com.example.studentproject.exception.StudentNotFoundException;
import com.example.studentproject.payload.StudentDto;
import com.example.studentproject.repository.StudentRepository;
import com.example.studentproject.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service




public class StudentServiceImpl  implements StudentService {
 private final StudentRepository studentRepository;
    private ModelMapper mapper;



    public StudentServiceImpl(StudentRepository studentRepository,ModelMapper mapper) {
        this.studentRepository = studentRepository;
        this.mapper=mapper;
    }

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = mapToEntity(studentDto);
     Student save = studentRepository.save(student);
        StudentDto map =mapToDto(save);
       return  map;
    }

    @Override
    public StudentDto updateNewStudent(StudentDto studentDto, long id) {
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new StudentNotFoundException("student", "id", id)
        );
        student.getId();
        student.getFirstName();
        student.getLastName();
        Student updatestudent = studentRepository.save(student);
        StudentDto studentDto1 = mapToDto( updatestudent);

return studentDto1;
    }

    @Override
    public StudentDto getByStudentId(long id) {
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new StudentNotFoundException("student", "id", id)
        );

        return  mapToDto(student);
    }

    @Override
    public void deleteByStudentId(long id) {
studentRepository.findById(id).orElseThrow(
        ()->  new StudentNotFoundException("student","id",id)
);
studentRepository.findById(id);
    }

    @Override
    public List<StudentDto> getALLStudents() {
        List<Student> all = studentRepository.findAll();
        List<StudentDto> collect = all.stream().map(student -> mapToDto(student)).collect(Collectors.toList());
        return collect;
    }


    private StudentDto mapToDto(Student save) {
        StudentDto map = mapper.map(save, StudentDto.class);

        return map;
    }

    private Student mapToEntity(StudentDto studentDto) {
        Student student = mapper.map(studentDto, Student.class);
return student;
    }
}
