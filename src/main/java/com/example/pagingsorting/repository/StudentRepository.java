package com.example.pagingsorting.repository;

import com.example.pagingsorting.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
    List<Student> findAll();
    Student findByName(String name);
}
