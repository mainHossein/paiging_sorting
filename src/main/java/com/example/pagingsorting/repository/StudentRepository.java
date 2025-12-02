package com.example.pagingsorting.repository;

import com.example.pagingsorting.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
    List<Student> findByNameIsLikeIgnoreCase(String name);

    List<Student> findByEmailIsLikeIgnoreCase(String email);

    List<Student> findByNameIsLikeIgnoreCaseAndEmailIsLikeIgnoreCase(String name, String email);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Student set Student.name = ?1, Student .email = ?2 where Student.id = ?3")
    int updateNameAndEmailById(String name, String email, UUID id);

    @Transactional
    @Modifying
    @Query("update Student s set s.name = ?1 where s.id = ?2")
    int updateNameById(String name, UUID id);

    @Transactional
    @Modifying
    @Query("update Student s set s.email = ?1 where s.id = ?2")
    int updateEmailById(String email, UUID id);

    
    @Query("select s from Student s")
    Page<Student> findAll(Pageable pageable);
}
