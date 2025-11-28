package com.example.pagingsorting.controller;

import com.example.pagingsorting.model.Student;
import com.example.pagingsorting.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/university/")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents(@RequestParam(required = false) String name,  @RequestParam(required = false) String email) {
        return studentService.findAllStudents(name, email);
    }

    @GetMapping("{student_id}")
    public Student getStudentById(@PathVariable UUID student_id) {
        return studentService.findStudentById(student_id);
    }

    @PostMapping
    public ResponseEntity<Student> postStudent(@RequestBody Student student) {
        Student savedStudent = studentService.saveStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }

    @PatchMapping("{student_id}")
    public ResponseEntity<Student> patchStudent(@PathVariable UUID student_id,@RequestBody Student student) {
        Boolean updateStatus = studentService.updateStudent(student_id, student);
        if (updateStatus == true) {
            return ResponseEntity.status(HttpStatus.OK).body(studentService.findStudentById(student_id));
        }else  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(studentService.findStudentById(student_id));
        }

    }

    @DeleteMapping("{student_id}")
    public ResponseEntity<Student> deleteStudentById(@PathVariable UUID student_id) {
        Boolean deleteStatus = studentService.deleteStudentById(student_id);
        if (deleteStatus == true) {
            return ResponseEntity.status(HttpStatus.OK).body(studentService.findStudentById(student_id));
        }else  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(studentService.findStudentById(student_id));
        }
    }

}
