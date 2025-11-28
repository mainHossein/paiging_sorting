package com.example.pagingsorting.service;

import com.example.pagingsorting.model.Student;
import com.example.pagingsorting.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@Import(StudentServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE )
class StudentServiceImplTest {

    @Autowired
    StudentService studentService;
    @Autowired
    StudentRepository studentRepository;

    @Test
    void findAllStudents() {
        List<Student> students = studentService.findAllStudents(null, null);
        assertNotNull(students);
    }

    @Test
    void saveStudent() {
        Student student = new Student();
        student.setName("Arthur Morgan");
        student.setEmail("morganemail@gmail.com");
        Student saveStudent = studentService.saveStudent(student);
        assertNotNull(saveStudent);
    }

    @Test
    void findStudentById() {
        Student student = studentRepository.findAll().get(0);
        Student founded = studentService.findStudentById(student.getId());
        assertNotNull(founded);
    }

    @Test
    void findStudentByName() {
        List<Student> students = studentService.findStudentByName("Jane");
        assertNotNull(students);
    }

    @Test
    void findStudentByEmail() {
        List<Student> students = studentService.findStudentByEmail("jane");
        assertNotNull(students);
        students.forEach(System.out::println);
    }

    @Test
    void findStudentByNameAndEmail() {
        List<Student> students = studentService.findStudentByNameAndEmail("jane", "jane");
        assertNotNull(students);
        students.forEach(System.out::println);
    }

    @Test
    void updateStudent() {
        Student student = studentRepository.findAll().get(0);
        System.out.println(studentRepository.findById(student.getId()));
        boolean updated = studentService.updateStudent(
                student.getId(), student);
        System.out.println(studentRepository.findById(student.getId()));
        assertThat(updated).isTrue();
    }

    @Test
    void deleteStudentById() {
        Student student = studentRepository.findAll().get(0);
        Boolean deletedStudent = studentService.deleteStudentById(student.getId());
        assertThat(deletedStudent).isTrue();
        assertThat(studentRepository.existsById(student.getId())).isFalse();
    }
}