package com.example.pagingsorting.repository;

import com.example.pagingsorting.model.AcademicField;
import com.example.pagingsorting.model.Address;
import com.example.pagingsorting.model.Student;
import jakarta.annotation.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstNameIsLikeIgnoreCaseAndLastNameIsLikeIgnoreCase(
            @Nullable String firstName, @Nullable String lastName);

    List<Student> findByFirstNameIsLikeIgnoreCase(@Nullable String firstName);

    List<Student> findByLastNameIsLikeIgnoreCase(@Nullable String lastName);

    @Override
    boolean existsById(Long aLong);

    @Transactional
    @Modifying
    @Query("""
            update Student s set s.firstName = ?1, s.lastName = ?2, s.email = ?3, s.academicField = ?4,
            s.phoneNumber = ?5, s.birthDate = ?6, s.address = ?7 where s.id = ?8""")
    int updateStudentById(
            @Nullable String firstName, @Nullable String lastName, @Nullable String email,
            @Nullable AcademicField academicField, @Nullable String phoneNumber, @Nullable LocalDate birthDate,
            @Nullable Address address, Long id);

}
