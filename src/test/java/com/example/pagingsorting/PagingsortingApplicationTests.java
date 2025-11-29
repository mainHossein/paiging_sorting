package com.example.pagingsorting;

import com.example.pagingsorting.controller.StudentController;
import com.example.pagingsorting.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PagingsortingApplicationTests {

    @Autowired
    StudentController studentController;

    @Test
    void contextLoads() {
        List<Student> allStudents = studentController.getAllStudents(null, null);
        allStudents.forEach(System.out::println);
    }

}
