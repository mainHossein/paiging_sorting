package com.example.pagingsorting.repository;

import com.example.pagingsorting.model.AcademicField;
import com.example.pagingsorting.model.Address;
import com.example.pagingsorting.model.Student;
import com.example.pagingsorting.model.Teacher;
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
            t.phoneNumber = ?5, t.birthDate = ?6, t.address = ?7 where t.id = ?8""")
    int updateFirstNameAndLastNameAndEmailAndAcademicFieldAndPhoneNumberAndBirthDateAndAddressById(
            @Nullable String firstName, @Nullable String lastName, @Nullable String email,
            @Nullable AcademicField academicField, @Nullable String phoneNumber, @Nullable Date birthDate,
            @Nullable Address address, Long id);

}
