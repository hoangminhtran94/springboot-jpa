package com.minhhoangtran.springjpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.minhhoangtran.springjpa.entity.Grade;

import jakarta.transaction.Transactional;

public interface GradeRepository extends CrudRepository<Grade, Long> {
    Optional<Grade> findByStudentIdAndCourseId(Long studentId, Long courseId);

    @Transactional
    void deleteByStudentIdAndCourseId(Long studentId, Long courseId);

    List<Grade> findByStudentId(Long studentId);

    List<Grade> findByCourseId(Long courseId);
}
