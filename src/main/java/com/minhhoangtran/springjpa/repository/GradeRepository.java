package com.minhhoangtran.springjpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.minhhoangtran.springjpa.entity.Grade;

public interface GradeRepository extends CrudRepository<Grade, Long> {
    Grade findByStudentId(Long studentId);
}
