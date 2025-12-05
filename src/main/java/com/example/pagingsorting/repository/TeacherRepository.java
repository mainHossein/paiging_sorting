package com.example.pagingsorting.repository;

import com.example.pagingsorting.model.*;
import jakarta.annotation.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findByFirstNameIsLikeIgnoreCaseAndLastNameIsLikeIgnoreCase(
            @Nullable String firstName, @Nullable String lastName);

    @Override
    boolean existsById(Long aLong);

    @Transactional
    @Modifying
    @Query("""
            update Teacher t set t.firstName = ?1, t.lastName = ?2, t.email = ?3, t.academicField = ?4,
                        t.academicRank = ?5, t.phoneNumber = ?6, t.birthDate = ?7, t.address = ?8 where t.id = ?9""")
    int updateFirstNameAndLastNameAndEmailAndAcademicFieldAndPhoneNumberAndBirthDateAndAddressById(
            @Nullable String firstName, @Nullable String lastName, @Nullable String email,
            @Nullable AcademicField academicField, @Nullable AcademicRank academicRank,
            @Nullable String phoneNumber, @Nullable Date birthDate, @Nullable Address address, Long id);

}
