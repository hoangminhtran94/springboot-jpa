package com.minhhoangtran.springjpa.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.minhhoangtran.springjpa.entity.Grade;

public interface GradeRepository extends CrudRepository<Grade, Long> {
    Grade findByStudentIdAndCourseId(Long studentId, Long courseId);
}
