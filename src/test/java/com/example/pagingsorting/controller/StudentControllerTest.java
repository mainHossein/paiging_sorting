package com.example.pagingsorting.controller;

import com.example.pagingsorting.repository.StudentRepository;
import com.example.pagingsorting.service.StudentService;
import jakarta.inject.Qualifier;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.awaitility.Awaitility.given;
import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(StudentController.class)
class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    StudentController studentController;


    @Test
    void getAllStudents() {
    }

    @Test
    void getStudentById() {
    }

    @Test
    void getStudentsByNameOrEmail() {
    }

    @Test
    void postStudent() {
    }

    @Test
    void patchStudent() {
    }

    @Test
    void deleteStudentById() {
    }
}