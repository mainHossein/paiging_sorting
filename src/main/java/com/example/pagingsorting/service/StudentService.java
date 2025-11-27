package com.example.pagingsorting.service;

import com.example.pagingsorting.model.Student;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface StudentService {
    List<Student> findAllStudents();
    Student saveStudent(Student student);
    Student findStudentById(UUID id);
    Student findStudentByName(String name);
    Student findStudentByEmail(String email);
    Student updateStudent(@Nullable String name, @Nullable String email);
    void deleteStudentById(UUID id);
}
