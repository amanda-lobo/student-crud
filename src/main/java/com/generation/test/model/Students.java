package com.generation.test.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @Column(nullable = false)
    private String studentName;
    @Column(nullable = false)
    private int studentAge;
    @Column(nullable = false)
    private Double firstSemesterGrade;
    @Column(nullable = false)
    private Double secondSemesterGrade;
    @Column(nullable = false)
    private String teachersName;
    @Column(nullable = false)
    private Integer roomNumber;
}

