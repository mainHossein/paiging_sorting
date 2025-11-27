package com.example.pagingsorting.repository;

import com.example.pagingsorting.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StudentRepositoryTest {
    @Autowired
    StudentRepository studentRepository;

    @Test
    void findByName() {
        List<Student> student = studentRepository.findByNameIsLikeIgnoreCase("daniel%");
        assertNotNull(student);
    }

    @Test
    void findByEmail() {
        List<Student> student = studentRepository.findByEmailIsLikeIgnoreCase("%Danie%");
        assertNotNull(student);
    }

    @Test
    void findByNameIsLikeIgnoreCaseAndEmailIsLikeIgnoreCase() {
        List<Student> student = studentRepository.findByNameIsLikeIgnoreCaseAndEmailIsLikeIgnoreCase("%dav%", "%ke%");
        assertNotNull(student);
    }

    @Test
    void updateNameAndEmailById() {
        int update = studentRepository.updateNameAndEmailById("Grace Red",
                null, UUID.fromString("36686147-0337-cfe4-c2f2-042fa1b4d0ba"));
        assertThat(update).isEqualTo(1);
    }
}