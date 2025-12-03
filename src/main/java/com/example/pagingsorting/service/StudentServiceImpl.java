package com.example.pagingsorting.service;

import com.example.pagingsorting.model.Student;
import com.example.pagingsorting.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Primary
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public List<Student> findAllStudents(String firstName, String lastName) {
        List<Student> students = List.of();
        if (firstName !=null && lastName == null){
            students = studentRepository.findByFirstNameIsLikeIgnoreCase(wildCardConverter(firstName));
        }if (firstName == null && lastName != null) {
            students = studentRepository.findByLastNameIsLikeIgnoreCase(wildCardConverter(lastName));

        }if (firstName != null && lastName != null) {
            students = studentRepository.findByFirstNameIsLikeIgnoreCaseAndLastNameIsLikeIgnoreCase(
                    wildCardConverter(firstName), wildCardConverter(lastName));
        }if (firstName == null && lastName == null) {
            students = studentRepository.findAll();
        }
        return students;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean updateStudent(UUID id, Student student) {
        int updated;
        if(student.getName() != null && student.getEmail() == null){
            updated = studentRepository.updateNameById(student.getName(), id);
        }else if (student.getName() == null && student.getEmail() != null) {
            updated = studentRepository.updateEmailById(student.getEmail(), id);
        }else if (student.getName() != null) {
            updated = studentRepository.updateNameAndEmailById(
                    student.getName(), student.getEmail(), id);
        }else {
            updated = 0;
        }
        return updated > 0;
    }

    @Override
    public Boolean deleteStudentById(Long id) {
        studentRepository.deleteById(id);
        return !studentRepository.existsById(id);
    }

    private String wildCardConverter(String string){
        return "%" + string + "%";
    }
}
