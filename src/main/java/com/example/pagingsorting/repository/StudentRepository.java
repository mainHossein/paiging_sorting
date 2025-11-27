package com.example.pagingsorting.repository;

import com.example.pagingsorting.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
    List<Student> findByNameIsLikeIgnoreCase(String name);

    List<Student> findByEmailIsLikeIgnoreCase(String email);

    @Transactional
    @Modifying
    @Query("update Student s set s.name = ?1, s.email = ?2 where s.id = ?3")
    int updateNameAndEmailById(@Nullable String name, @Nullable String email, UUID id);
}
