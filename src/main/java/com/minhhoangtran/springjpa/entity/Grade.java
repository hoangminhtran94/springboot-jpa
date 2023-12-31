package com.minhhoangtran.springjpa.entity;

import com.minhhoangtran.springjpa.validators.Score;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "grade", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "student_id", "course_id" })
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "score", nullable = false)
    @Score
    private String score;

    @ManyToOne(optional = false)
    @JoinColumn(referencedColumnName = "id", name = "student_id")
    private Student student;

    @ManyToOne(optional = false)
    @JoinColumn(referencedColumnName = "id", name = "course_id")
    private Course course;
}
