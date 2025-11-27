package com.example.pagingsorting.service;

import com.example.pagingsorting.model.Student;
import com.example.pagingsorting.repository.StudentRepository;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return null;
    }

    @Override
    public Student findStudentById(UUID id) {
        return null;
    }

    @Override
    public Student findStudentByName(String name) {
        return null;
    }

    @Override
    public Student findStudentByEmail(String email) {
        return null;
    }

    @Override
    public Student updateStudent(@Nullable String name, @Nullable String email) {
        return null;
    }

    @Override
    public void deleteStudentById(UUID id) {

    }
}
