package com.example.pagingsorting.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Teacher extends Person {
    @Enumerated(EnumType.STRING)
    private AcademicRank academicRank;
}
