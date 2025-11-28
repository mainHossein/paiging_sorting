package com.example.pagingsorting.service;

import com.example.pagingsorting.model.Student;
import com.example.pagingsorting.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service()
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAllStudents(String name, String email) {
        List<Student> students = List.of();
        if (name !=null && email == null){
            students = studentRepository.findByNameIsLikeIgnoreCase(wildCardConverter(name));
        }if (name == null && email != null) {
            students = studentRepository.findByEmailIsLikeIgnoreCase(wildCardConverter(email));

        }if (name != null && email != null) {
            students = studentRepository.findByNameIsLikeIgnoreCaseAndEmailIsLikeIgnoreCase(
                    wildCardConverter(name), wildCardConverter(email));
        }if (name == null && email == null) {
            students = studentRepository.findAll();
        }
        return students;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findStudentById(UUID id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Student> findStudentByName(String name) {
        return studentRepository.findByNameIsLikeIgnoreCase(wildCardConverter(name));
    }

    @Override
    public List<Student> findStudentByEmail(String email) {
        return studentRepository.findByEmailIsLikeIgnoreCase(wildCardConverter(email));
    }

    @Override
    public List<Student> findStudentByNameAndEmail(String name, String email) {
        return studentRepository.findByNameIsLikeIgnoreCaseAndEmailIsLikeIgnoreCase(
                wildCardConverter(name), wildCardConverter(email));
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
    public Boolean deleteStudentById(UUID id) {
        studentRepository.deleteById(id);
        return !studentRepository.existsById(id);
    }

    private String wildCardConverter(String string){
        return "%" + string + "%";
    }
}
