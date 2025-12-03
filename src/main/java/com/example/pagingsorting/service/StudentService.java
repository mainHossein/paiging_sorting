package com.example.pagingsorting.service;

import com.example.pagingsorting.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface StudentService {
    List<Student> findAllStudents(String firstName, String lastName);
    Student saveStudent(Student student);
    Student findStudentById(Long id);
    Boolean updateStudent(UUID id, Student student);
    Boolean deleteStudentById(Long id);
}
