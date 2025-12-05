package com.example.pagingsorting.bootstrap;

import com.example.pagingsorting.model.AcademicField;
import com.example.pagingsorting.model.Address;
import com.example.pagingsorting.model.Student;
import com.example.pagingsorting.model.Teacher;
import com.example.pagingsorting.repository.StudentRepository;
import com.example.pagingsorting.repository.TeacherRepository;
import com.example.pagingsorting.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final StudentService studentService;
    @Override
    public void run(String... args) throws Exception {
//        Student student = new Student();
//        student.setFirstName("John");
//        student.setLastName("Doe");
//        student.setEmail("Johnemail@gmail.com");
//        student.setPhoneNumber("+1 8848394342");
//        student.setAddress(new Address("Miami", "26th street", "784584545", "United States"));
//        student.setBirthDate(LocalDate.of(1980, 1, 1));
//        student.setAcademicField(AcademicField.COMPUTER_SCIENCE);
//        studentRepository.save(student);
        Student student = new Student();
        student.setFirstName("Hossein");
        student.setAddress(new Address("Tehran", null, null, "Iran"));
        Boolean b = studentService.updateStudent(8L, student);
        System.out.println(b);
    }
}
