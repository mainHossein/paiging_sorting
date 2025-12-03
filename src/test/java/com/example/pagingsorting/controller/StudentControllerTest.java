package com.example.pagingsorting.controller;

import com.example.pagingsorting.model.Student;
import com.example.pagingsorting.service.StudentService;
import org.junit.jupiter.api.MediaType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentController.class)
class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    StudentService studentService;



    @Test
    void getAllStudents(){

    }

    @Test
    void getStudentById() throws Exception {

        Student student = new Student();
        student.setId(UUID.randomUUID());
        student.setName("testName");
        student.setEmail("testEmail");
        given(studentService.findStudentById(any(UUID.class))).willReturn(student);
        mockMvc.perform(get("/university/" + UUID.randomUUID())
                    .accept(String.valueOf(MediaType.APPLICATION_JSON)))
            .andExpect(status().isOk())
                .andExpect(content().contentType(String.valueOf(MediaType.APPLICATION_JSON)))
                .andExpect(jsonPath("$.name").value("testName"));
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