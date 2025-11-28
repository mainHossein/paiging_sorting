package com.example.pagingsorting.controller;

import com.example.pagingsorting.model.Student;
import com.example.pagingsorting.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("university/")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.findAllStudents();
    }

    @GetMapping("student_id")
    public Student getStudentById(@PathVariable UUID id) {
        return studentService.findStudentById(id);
    }

    @GetMapping
    public List<Student> getStudentsByNameOrEmail(@RequestParam(required = false) String name,  @RequestParam(required = false) String email) {
        List<Student> students = List.of();
        if (name !=null && email == null){
            students = studentService.findStudentByName(name);
        }if (name == null && email != null) {
            students = studentService.findStudentByEmail(email);

        }if (name != null && email != null) {
            students = studentService.findStudentByNameAndEmail(name, email);
        }
        return students;
    }

    @PostMapping
    public ResponseEntity<Student> postStudent(@RequestBody Student student) {
        Student savedStudent = studentService.saveStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }

    @PatchMapping
    public ResponseEntity<Student> patchStudent(@PathVariable UUID id, @RequestParam(required = false) String name,  @RequestParam(required = false) String email) {
        Boolean updateStatus = studentService.updateStudent(name, email, id);
        if (updateStatus == true) {
            return ResponseEntity.status(HttpStatus.OK).body(studentService.findStudentById(id));
        }else  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(studentService.findStudentById(id));
        }

    }

    @DeleteMapping
    public ResponseEntity<Student> deleteStudentById(@PathVariable UUID id) {
        Boolean deleteStatus = studentService.deleteStudentById(id);
        if (deleteStatus == true) {
            return ResponseEntity.status(HttpStatus.OK).body(studentService.findStudentById(id));
        }else  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(studentService.findStudentById(id));
        }
    }

}
