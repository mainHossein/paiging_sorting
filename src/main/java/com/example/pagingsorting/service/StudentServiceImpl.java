package com.example.pagingsorting.service;

import com.example.pagingsorting.model.Student;
import com.example.pagingsorting.repository.StudentRepository;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service()
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
        return studentRepository.save(student);
    }

    @Override
    public Student findStudentById(UUID id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Student> findStudentByName(String name) {
        return studentRepository.findByNameIsLikeIgnoreCase("%" + name + "%");
    }

    @Override
    public List<Student> findStudentByEmail(String email) {
        return studentRepository.findByEmailIsLikeIgnoreCase("%" + email + "%");
    }

    @Override
    public List<Student> findStudentByNameAndEmail(String name, String email) {
        return studentRepository.findByNameIsLikeIgnoreCaseAndEmailIsLikeIgnoreCase(
                "%" + name + "%", "%" + email + "%");
    }

    @Override
    public Boolean updateStudent(@Nullable String name, @Nullable String email, UUID id) {
        int updated = studentRepository.updateNameAndEmailById(name, email, id);
        return updated > 0;
    }

    @Override
    public Boolean deleteStudentById(UUID id) {
        studentRepository.deleteById(id);
        return !studentRepository.existsById(id);
    }
}
