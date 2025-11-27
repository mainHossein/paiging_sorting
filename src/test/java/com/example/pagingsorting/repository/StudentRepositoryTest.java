package com.example.pagingsorting.repository;

import com.example.pagingsorting.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
//@Import(StudentRepository.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StudentRepositoryTest {
    @Autowired
    StudentRepository studentRepository;

    @Test
    void findByName() {
        List<Student> student = studentRepository.findByNameIsLikeIgnoreCase("Danie%");
        assertNotNull(student);

    }

    @Test
    void findByEmail() {
        List<Student> student = studentRepository.findByEmailIsLikeIgnoreCase("%Danie%");
        assertNotNull(student);
        student.forEach(System.out::println);
    }

    @Test
    void updateNameAndEmailById() {
    }
}