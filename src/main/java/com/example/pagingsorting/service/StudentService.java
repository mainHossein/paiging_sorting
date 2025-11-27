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
    List<Student> findStudentByName(String name);
    List<Student> findStudentByEmail(String email);
    List<Student> findStudentByNameAndEmail(String name, String email);
    Boolean updateStudent(@Nullable String name, @Nullable String email, UUID id);
    Boolean deleteStudentById(UUID id);
}
